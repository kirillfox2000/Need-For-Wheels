package ru.bersenev_kirill.need_for_wheels.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.bersenev_kirill.need_for_wheels.domain.model.Question

@Dao
interface QuestionDao {
    @Query("SELECT * from question")
    suspend fun getAll(): List<Question>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(questions: List<Question>)
}