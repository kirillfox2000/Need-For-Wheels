package ru.bersenev_kirill.need_for_wheels.data.database

import android.content.Context
import androidx.room.Room

object DatabaseProvider {
    private var db: NFWDatabase? = null

    fun provideDatabase(context: Context): NFWDatabase {
        return db ?: Room.databaseBuilder(
            context.applicationContext,
           NFWDatabase::class.java, "NFW_database"
        )
            .build()
            .also { db = it }
    }
}