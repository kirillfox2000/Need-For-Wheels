package ru.bersenev_kirill.need_for_wheels.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.bersenev_kirill.need_for_wheels.domain.model.Manufacturer

@Dao
interface ManufacturerDao {
    @Query("SELECT * from manufacturer")
    suspend fun getAll(): List<Manufacturer>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(manufacturers: List<Manufacturer>)
}