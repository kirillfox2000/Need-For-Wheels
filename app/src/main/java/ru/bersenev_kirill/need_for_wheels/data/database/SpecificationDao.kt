package ru.bersenev_kirill.need_for_wheels.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.bersenev_kirill.need_for_wheels.domain.model.Specification

@Dao
interface SpecificationDao {
    @Query("SELECT * from specification")
    suspend fun getAll(): List<Specification>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(specifications: List<Specification>)
}