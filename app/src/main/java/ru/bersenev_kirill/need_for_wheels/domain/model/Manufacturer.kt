package ru.bersenev_kirill.need_for_wheels.domain.model


import androidx.room.ColumnInfo
import androidx.room.Entity
import kotlinx.serialization.Serializable

@Serializable
@Entity(primaryKeys = ["name","coverResId"])
data class Manufacturer(
    @ColumnInfo val name : String,
    @ColumnInfo val fullName : String,
    @ColumnInfo val address : String,
    @ColumnInfo val coverResId : Int
)