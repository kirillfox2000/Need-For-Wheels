package ru.bersenev_kirill.need_for_wheels.presentation.fragments


import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import ru.bersenev_kirill.need_for_wheels.R
import ru.bersenev_kirill.need_for_wheels.presentation.activity.MainActivity
import ru.bersenev_kirill.need_for_wheels.presentation.adapter.ManufacturerAdapter
import ru.bersenev_kirill.need_for_wheels.data.DataSource
import ru.bersenev_kirill.need_for_wheels.databinding.FragmentManufacturersBinding
import ru.bersenev_kirill.need_for_wheels.data.network.NetworkService
import kotlinx.coroutines.*
import kotlinx.serialization.ExperimentalSerializationApi

class ManufacturersFragment : Fragment(R.layout.fragment_manufacturers) {
    companion object {
        const val KEY_NAME = "name"
        const val KEY_ICON_RES_ID = "iconResId"

        fun newInstance (argName : String?, argIcon : Int?) : ManufacturersFragment {
            val args = bundleOf(
                KEY_NAME to argName,
                KEY_ICON_RES_ID to argIcon
            )
            val fragment = ManufacturersFragment()
            fragment.arguments = args
            return fragment
        }
    }

    private lateinit var binding: FragmentManufacturersBinding

    private val coroutineExceptionHandler = CoroutineExceptionHandler { context, exception ->
        binding.progressBar.visibility = View.GONE
        println("CoroutineExceptionHandler got $exception")
    }

    private val scope = CoroutineScope(Dispatchers.Main + Job() + coroutineExceptionHandler)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentManufacturersBinding.bind(view)
        val name = arguments?.getString(TiresFragment.KEY_NAME)
        val description = arguments?.getString(TiresFragment.KEY_DESCRIPTION)
        val iconResId = arguments?.getInt(TiresFragment.KEY_ICON_RES_ID)

        binding.rvManufacturers.layoutManager = LinearLayoutManager(requireContext())
        binding.rvManufacturers.adapter = ManufacturerAdapter(DataSource.manufacturers) {
            (activity as MainActivity).navigateToFragment(
                TiresFragment.newInstance(name, description, iconResId)

            )
        }
    }

    @ExperimentalSerializationApi
    private fun loadManufacturer() {
        scope.launch {
            val manufacturers = NetworkService.loadManufacturers()
            binding.rvManufacturers.layoutManager = LinearLayoutManager(context)
            binding.rvManufacturers.adapter = ManufacturerAdapter(manufacturers) {}
            binding.progressBar.visibility = View.GONE
            binding.swRefreshRW.isRefreshing = false
        }
    }
}