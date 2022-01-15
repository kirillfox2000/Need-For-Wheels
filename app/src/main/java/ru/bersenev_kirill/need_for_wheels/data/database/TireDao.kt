package ru.bersenev_kirill.need_for_wheels.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.bersenev_kirill.need_for_wheels.domain.model.Tire

@Dao
interface TireDao {
    @Query("SELECT * from tire")
    suspend fun getAll(): List<Tire>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(phones: List<Tire>)
}