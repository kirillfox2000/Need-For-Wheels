package ru.bersenev_kirill.need_for_wheels.presentation.fragments

import android.os.Bundle
import android.view.View
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlinx.serialization.ExperimentalSerializationApi
import ru.bersenev_kirill.need_for_wheels.presentation.onClickFlow
import ru.bersenev_kirill.need_for_wheels.presentation.onRefreshFlow
import ru.bersenev_kirill.need_for_wheels.R
import ru.bersenev_kirill.need_for_wheels.presentation.activity.MainActivity
import ru.bersenev_kirill.need_for_wheels.presentation.adapter.TireAdapter
import ru.bersenev_kirill.need_for_wheels.data.DataSource
import ru.bersenev_kirill.need_for_wheels.databinding.FragmentTiresBinding
import ru.bersenev_kirill.need_for_wheels.domain.model.Tire
import ru.bersenev_kirill.need_for_wheels.data.network.NetworkService
import ru.bersenev_kirill.need_for_wheels.presentation.ScreenState
import ru.bersenev_kirill.need_for_wheels.presentation.viewmodel.TiresViewModel

class TiresFragment : Fragment(R.layout.fragment_tires) {

        private val tiresViewModel by lazy { TiresViewModel(requireContext(), lifecycleScope) }
        companion object {
        const val KEY_NAME = "name"
        const val KEY_DESCRIPTION = "description"
        const val KEY_ICON_RES_ID = "iconResId"

        fun newInstance ( argName : String?, argDescription : String?, argIcon : Int?) : TiresFragment {
            val args = bundleOf(

                KEY_NAME to argName,
                KEY_DESCRIPTION to argDescription,
                KEY_ICON_RES_ID to argIcon
            )
            val fragment = TiresFragment()
            fragment.arguments = args
            return fragment
        }
    }

    private fun setLoading(isLoading: Boolean) = with(binding) {
        progressBar.isVisible = isLoading && !rvTires.isVisible
        swRefreshRW.isRefreshing = isLoading && rvTires.isVisible
    }

    private fun setData(headtires: List<Tire>?) = with(binding){
        rvTires.isVisible = headtires != null
        val name = arguments?.getString(TireFragment.KEY_NAME)
        val description = arguments?.getString(TireFragment.KEY_DESCRIPTION)
        val iconResId = arguments?.getInt(TireFragment.KEY_ICON_RES_ID)
        val character = arguments?.getString(TireFragment.KEY_CHARACTERISTICS)

        binding.rvTires.layoutManager = LinearLayoutManager(requireContext())
        binding.rvTires.adapter = TireAdapter(DataSource.tires) {
            (activity as MainActivity).navigateToFragment(
                TireFragment.newInstance(name, description, iconResId, character)
            )
        }
    }

    private fun setError(message: String?) = with(binding){
        ErrLayout.isVisible = message != null
        textError.text = message
    }

    private lateinit var binding: FragmentTiresBinding

    private val coroutineExceptionHandler = CoroutineExceptionHandler { context, exception ->
        binding.progressBar.visibility = View.GONE
        println("CoroutineExceptionHandler got $exception")

    }

    private val scope = CoroutineScope(Dispatchers.Main + Job() + coroutineExceptionHandler)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentTiresBinding.bind(view)
        merge(
            flowOf(Unit),
            binding.swRefreshRW.onRefreshFlow(),
            binding.buttonError.onClickFlow()
        )
            .flatMapLatest{loadTiires()}
            .distinctUntilChanged()
        tiresViewModel.screenState.onEach{
                when(it){
                    is ScreenState.DataLoaded -> {
                        setLoading(false)
                        setError(null)
                        setData(it.tires)
                    }
                    is ScreenState.Error -> {
                        setLoading(false)
                        setError(it.error)
                        setData(null)
                    }
                    ScreenState.Loading -> {
                        setLoading(true)
                        setError(null)
                    }
                }
            }
            .launchIn(lifecycleScope)
        if(savedInstanceState == null) {
            tiresViewModel.loadData()
        }
        binding.swRefreshRW.setOnRefreshListener {
            tiresViewModel.loadData()
        }
        binding.swRefreshRW.setOnRefreshListener {
            tiresViewModel.loadData()
        }
    }

    @ExperimentalSerializationApi
    private fun loadTiires() = flow {

        emit(ScreenState.Loading)
        val tires = NetworkService.loadTires()
        emit(ScreenState.DataLoaded(tires))
    }
        .catch{
            emit(ScreenState.Error(getString(R.string.errorConnect)))
        }


}