package ru.bersenev_kirill.need_for_wheels.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.bersenev_kirill.need_for_wheels.domain.model.Tire

@Database(
    entities = [Tire::class],
    version = 1
)
abstract class NFWDatabase : RoomDatabase() {
    abstract fun tireDao() : TireDao
    abstract fun manufacturerDao(): ManufacturerDao
    abstract fun questionDao(): QuestionDao
    abstract fun reviewDao(): ReviewDao
    abstract fun specificationDao(): SpecificationDao
    abstract fun userDao(): UserDao
}