package ru.bersenev_kirill.need_for_wheels.domain.model

import androidx.annotation.DrawableRes
import kotlinx.serialization.Serializable

@Serializable
data class Tire (

    val manufacturer: Manufacturer,
    val name : String,
    val price : Double,
    val specifications: Specification,
    val reviews: List<Review>,
    val question: List<Question>,
    val coverResId : Int
)