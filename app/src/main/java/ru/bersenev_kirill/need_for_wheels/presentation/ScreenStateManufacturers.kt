package ru.bersenev_kirill.need_for_wheels.presentation

import ru.bersenev_kirill.need_for_wheels.domain.model.Manufacturer

sealed class ScreenStateManufacturers{
    data class DataLoaded(val tires: List<Manufacturer>) : ScreenStateManufacturers()
    object Loading : ScreenStateManufacturers()
    data class Error(val error: String) : ScreenStateManufacturers()
}