package ru.bersenev_kirill.need_for_wheels.domain.model


import kotlinx.serialization.Serializable

@Serializable
data class Manufacturer(
    val name : String,
    val fullName : String,
    val address : String,
    val coverResId : Int
)