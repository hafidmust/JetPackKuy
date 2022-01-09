package com.hafidmust.academy.data.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.hafidmust.academy.data.CourseEntity
import com.hafidmust.academy.data.ModuleEntity

@Database(entities = [CourseEntity::class, ModuleEntity::class], version = 1, exportSchema = false)
abstract class AcademyDatabase : RoomDatabase() {
    abstract fun academyDao() : AcademyDao

    companion object{
        @Volatile
        private var INSTANCE: AcademyDatabase? = null

        fun getInstance(context: Context): AcademyDatabase =
            INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    AcademyDatabase::class.java,
                    "Academies.db"
                ).build().apply {
                    INSTANCE = this
                }
            }
    }
}