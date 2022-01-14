package ru.bersenev_kirill.need_for_wheels.presentation.fragments

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import ru.bersenev_kirill.need_for_wheels.R
import ru.bersenev_kirill.need_for_wheels.databinding.FragmentTireBinding

class TireFragment : Fragment(R.layout.fragment_tire) {
    companion object {
        const val KEY_NAME = "name"
        const val KEY_DESCRIPTION = "description"
        const val KEY_ICON_RES_ID = "iconResId"
        const val KEY_CHARACTERISTICS = "characteristics"

        fun newInstance (argName: String?, argDescr: String?, argIcon: Int?, argCharacter: String?) : TireFragment {
            val args = bundleOf(
                KEY_NAME to argName,
                KEY_DESCRIPTION to argDescr,
                KEY_ICON_RES_ID to argIcon,
                KEY_CHARACTERISTICS to argCharacter

            )
            val fragment = TireFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentTireBinding.bind(view)



        val name = arguments?.getString(KEY_NAME)
        val description = arguments?.getString(KEY_DESCRIPTION)
        val iconResId = arguments?.getInt(KEY_ICON_RES_ID)
       // val character = arguments?.getString(KEY_CHARACTERISTICS)

       binding.tvName.text = name
        if (iconResId != null) {
            binding.ivAvatar.setImageResource(iconResId)
        }
       binding.tvSpecification.text = description
       // binding.tvCharacteristics.text = character
        //binding.rvTires.layoutManager = LinearLayoutManager(requireContext())
       // binding.rvTire.adapter =
        //TireAdapter(DataSource.tires) {

        //(activity as MainActivity).navigateToFragment(
        //TiresFragment.newInstance(name, description, iconResId)

        // )
    //}

       }
    }
