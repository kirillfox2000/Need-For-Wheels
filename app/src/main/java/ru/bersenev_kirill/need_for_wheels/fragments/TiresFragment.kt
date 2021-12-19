package ru.bersenev_kirill.need_for_wheels.fragments

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import ru.bersenev_kirill.need_for_wheels.R
import ru.bersenev_kirill.need_for_wheels.activity.MainActivity
import ru.bersenev_kirill.need_for_wheels.adapter.TireAdapter
import ru.bersenev_kirill.need_for_wheels.data.DataSource
import ru.bersenev_kirill.need_for_wheels.databinding.FragmentTiresBinding

class TiresFragment : Fragment(R.layout.fragment_tires) {
    companion object {
        const val KEY_NAME = "name"
        const val KEY_DESCRIPTION = "description"
        const val KEY_ICON_RES_ID = "iconResId"

        fun newInstance (argName : String?, argDescr : String?, argIcon : Int?) : TiresFragment {
            val args = bundleOf(
                KEY_NAME to argName,
                KEY_DESCRIPTION to argDescr,
                KEY_ICON_RES_ID to argIcon
            )
            val fragment = TiresFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentTiresBinding.bind(view)
        val name = arguments?.getString(KEY_NAME)
        val description = arguments?.getString(KEY_DESCRIPTION)
        val iconResId = arguments?.getInt(KEY_ICON_RES_ID)

        binding.rvTires.layoutManager = LinearLayoutManager(requireContext())
        binding.rvTires.adapter = TireAdapter(DataSource.tires) {
            (activity as MainActivity).navigateToFragment(
                TiresFragment.newInstance(name, description, iconResId)
            )
        }
    }
}