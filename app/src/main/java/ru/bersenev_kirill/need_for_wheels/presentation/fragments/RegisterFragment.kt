package ru.bersenev_kirill.need_for_wheels.presentation.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import ru.bersenev_kirill.need_for_wheels.R
import ru.bersenev_kirill.need_for_wheels.presentation.activity.MainActivity
import ru.bersenev_kirill.need_for_wheels.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment(R.layout.fragment_register) {
    companion object{
        fun newInstance() = RegisterFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentRegisterBinding.bind(view)
        (activity as MainActivity).navigateToFragment(
            LogInFragment.newInstance()
        )
    }
}