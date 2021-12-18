package ru.bersenev_kirill.need_for_wheels.model

import androidx.annotation.DrawableRes

data class Tire (
    val manufacturer: Manufacturer,
    val name : String,
    val price : Double,
    val specifications: Specification,
    val reviews: List<Review>,
    val question: List<Question>,
    val coverResId : Int
)