package ru.bersenev_kirill.need_for_wheels.model

import java.util.*

data class Review(
    val rating : Double,
    val date: String,
    val user: User,
    val advantages : String,
    val limitations : String
)