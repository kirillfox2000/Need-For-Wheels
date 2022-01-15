package ru.bersenev_kirill.need_for_wheels.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import kotlinx.serialization.Serializable

@Serializable
@Entity
data class Specification(
    @ColumnInfo val seasonality : String,
    @ColumnInfo val size : String,
    @ColumnInfo val height : String,
    @ColumnInfo val width : String,
    @ColumnInfo val speed_index : String

)