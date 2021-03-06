package com.hafidmust.mynoteapps.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import java.util.concurrent.Executors

@Database(entities = [Note::class], version = 1)
abstract class NoteRoomDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao

    companion object {
        @Volatile
        private var INSTANCE: NoteRoomDatabase? = null

        @JvmStatic
        fun getDatabase(context: Context): NoteRoomDatabase {
            if (INSTANCE == null) {
                synchronized(NoteRoomDatabase::class.java) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        NoteRoomDatabase::class.java, "note_database"
                    )
                        .addCallback(object : Callback() {
                            override fun onCreate(db: SupportSQLiteDatabase) {
                                add()
                            }
                        })
                        .build()
                }
            }
            return INSTANCE as NoteRoomDatabase
        }

        private fun add() {
            Executors.newSingleThreadExecutor().execute {
                val list: MutableList<Note> = ArrayList()
                for (i in 0..100){
                    val dummyNOte = Note()
                    dummyNOte.title = "Tugas $i"
                    dummyNOte.description = "Belajar hari ke $i"
                    dummyNOte.date = "2022/01/$i"
                    list.add(dummyNOte)
                }
               INSTANCE?.noteDao()?.insertAll(list)
            }
        }
    }
}