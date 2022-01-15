package ru.bersenev_kirill.need_for_wheels.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.bersenev_kirill.need_for_wheels.domain.model.User

@Dao
interface UserDao {
    @Query("SELECT * from user")
    suspend fun getAll(): List<User>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(users: List<User>)
}