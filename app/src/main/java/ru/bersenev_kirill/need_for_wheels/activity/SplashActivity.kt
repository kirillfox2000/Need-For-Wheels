package ru.bersenev_kirill.need_for_wheels.activity

import android.app.Activity
import android.os.Bundle
import ru.bersenev_kirill.need_for_wheels.R

class SplashActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ac_log_in)
    }
}