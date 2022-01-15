package ru.bersenev_kirill.need_for_wheels.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ru.bersenev_kirill.need_for_wheels.domain.model.*

@Database(
    entities = [Tire::class, Manufacturer::class, Question::class, Review::class, Specification::class, User::class],
    version = 1
)
@TypeConverters(UserConverter::class, ReviewConverter::class, ManufacturerConverter::class,SpecificationConverter::class,QuestionConverter::class)
abstract class NFWDatabase : RoomDatabase() {
    abstract fun tireDao() : TireDao
    abstract fun manufacturerDao(): ManufacturerDao
    abstract fun questionDao(): QuestionDao
    abstract fun reviewDao(): ReviewDao
    abstract fun specificationDao(): SpecificationDao
    abstract fun userDao(): UserDao
}