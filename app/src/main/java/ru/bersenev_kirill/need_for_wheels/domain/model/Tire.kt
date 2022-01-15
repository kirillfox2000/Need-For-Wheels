package ru.bersenev_kirill.need_for_wheels.domain.model

import androidx.annotation.DrawableRes
import androidx.room.ColumnInfo
import androidx.room.Entity
import kotlinx.serialization.Serializable

@Serializable
@Entity(primaryKeys = ["name","coverResId"])
data class Tire (

    @ColumnInfo val manufacturer: Manufacturer,
    @ColumnInfo val name : String,
    @ColumnInfo val price : Double,
    @ColumnInfo val specifications: Specification,
    @ColumnInfo val reviews: List<Review>,
    @ColumnInfo val question: List<Question>,
    @ColumnInfo val coverResId : Int
)