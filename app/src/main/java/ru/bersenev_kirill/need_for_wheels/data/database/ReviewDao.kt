package ru.bersenev_kirill.need_for_wheels.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.bersenev_kirill.need_for_wheels.domain.model.Review

@Dao
interface ReviewDao {
    @Query("SELECT * from review")
    suspend fun getAll(): List<Review>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(reviews: List<Review>)
}