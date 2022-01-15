package ru.bersenev_kirill.need_for_wheels.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.TypeConverters
import kotlinx.serialization.Serializable
import ru.bersenev_kirill.need_for_wheels.data.database.UserConverter
import java.util.*

@Serializable
@Entity(primaryKeys = ["user","date","question","coverResId"])
data class Question(
    @TypeConverters(UserConverter::class)
    @ColumnInfo val user: User,
    @ColumnInfo val date: String,
    @ColumnInfo val question : String,
    @ColumnInfo val coverResId : Int
)