package ru.bersenev_kirill.need_for_wheels.presentation

import ru.bersenev_kirill.need_for_wheels.domain.model.Manufacturer
import ru.bersenev_kirill.need_for_wheels.domain.model.Tire

sealed class ScreenState{
    data class DataLoaded(val tires: List<Tire>) : ScreenState()
    object Loading : ScreenState()
    data class Error(val error: String) : ScreenState()
}