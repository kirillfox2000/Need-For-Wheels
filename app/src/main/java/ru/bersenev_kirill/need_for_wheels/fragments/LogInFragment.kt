package ru.bersenev_kirill.need_for_wheels.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ru.bersenev_kirill.need_for_wheels.R
import ru.bersenev_kirill.need_for_wheels.activity.MainActivity
import ru.bersenev_kirill.need_for_wheels.databinding.FragmentLogInBinding


class LogInFragment : Fragment(R.layout.fragment_log_in) {
    companion object{
        fun newInstance()=LogInFragment()
}
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentLogInBinding.bind(view)
        val name = arguments?.getString(ManufacturersFragment.KEY_NAME)
        val iconResId = arguments?.getInt(ManufacturersFragment.KEY_ICON_RES_ID)
        (activity as MainActivity).navigateToFragment(
            ManufacturersFragment.newInstance(name,iconResId)
        )

    }
}