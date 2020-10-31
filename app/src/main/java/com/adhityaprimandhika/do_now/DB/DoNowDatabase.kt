package com.adhityaprimandhika.do_now.DB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.adhityaprimandhika.do_now.model.Task

@Database(entities = [Task::class], version = 1, exportSchema = false)
abstract class DoNowDatabase: RoomDatabase() {

    companion object {
        @Volatile
        private var INSTANCE : DoNowDatabase? = null

        fun getDatabase(context: Context): DoNowDatabase {
            return INSTANCE ?: synchronized(this) {
                // Create database here
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DoNowDatabase::class.java,
                    "task_db"
                )
                    .allowMainThreadQueries() //allows Room to executing task in main thread
                    .fallbackToDestructiveMigration() //allows Room to recreate database if no migrations found
                    .build()

                INSTANCE = instance
                instance
            }
        }
    }

    abstract fun getNoteDao() : TaskDao
}