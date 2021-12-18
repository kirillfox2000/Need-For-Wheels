package ru.bersenev_kirill.need_for_wheels.model

data class User(
    val name : String,
    val lastName : String,
    val phone : String,
    val email : String,
    val address : String,
    val coverResId : Int
)