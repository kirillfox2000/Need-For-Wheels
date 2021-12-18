package ru.bersenev_kirill.need_for_wheels.model

import java.util.*

data class Question(
    val user: User,
    val date: String,
    val question : String,
    val coverResId : Int
)