package ru.bersenev_kirill.need_for_wheels.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import ru.bersenev_kirill.need_for_wheels.R
import ru.bersenev_kirill.need_for_wheels.databinding.FragmentLogInBinding


class LogInFragment : Fragment(R.layout.fragment_log_in) {
    companion object{
        fun newInstance()=LogInFragment()
}
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentLogInBinding.bind(view)
    }
}