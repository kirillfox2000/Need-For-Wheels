package ru.bersenev_kirill.need_for_wheels.presentation.activity

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import ru.bersenev_kirill.need_for_wheels.R
import ru.bersenev_kirill.need_for_wheels.databinding.ActivityMainBinding
import ru.bersenev_kirill.need_for_wheels.presentation.fragments.SplashFragment



class MainActivity : FragmentActivity() {
    fun navigateToFragment(fmt : Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView, fmt)
            .addToBackStack(fmt.javaClass.name)
            .commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        if (savedInstanceState == null) {
            navigateToFragment(SplashFragment.newInstance())
        }
    }
}