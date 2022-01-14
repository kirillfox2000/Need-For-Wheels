package ru.bersenev_kirill.need_for_wheels.presentation

import ru.bersenev_kirill.need_for_wheels.domain.model.Manufacturer

sealed class ScreenStateManufacturers{
    data class DataLoaded(val tires: List<Manufacturer>) : ScreenState()
    object Loading : ScreenState()
    data class Error(val error: String) : ScreenState()
}