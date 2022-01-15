package ru.bersenev_kirill.need_for_wheels.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.TypeConverters
import kotlinx.serialization.Serializable
import ru.bersenev_kirill.need_for_wheels.data.database.UserConverter
import java.util.*
@Serializable

@Entity(primaryKeys = ["date"])
data class Review(
    @ColumnInfo val rating : Double,
    @ColumnInfo val date: String,
    @TypeConverters(UserConverter::class)
    @ColumnInfo val user: User,
    @ColumnInfo val advantages : String,
    @ColumnInfo val limitations : String
)