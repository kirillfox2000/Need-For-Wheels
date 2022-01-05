package ru.bersenev_kirill.need_for_wheels.fragments


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import ru.bersenev_kirill.need_for_wheels.R
import ru.bersenev_kirill.need_for_wheels.activity.MainActivity
import ru.bersenev_kirill.need_for_wheels.databinding.FragmentSplashBinding

class SplashFragment : Fragment(R.layout.fragment_splash) {
    companion object{
        fun newInstance() = SplashFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentSplashBinding.bind(view)
        (activity as MainActivity).navigateToFragment(
            RegisterFragment.newInstance()
        )
    }
}