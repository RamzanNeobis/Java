package ru.startandroid.develop.javatutorial.bd

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ru.startandroid.develop.javatutorial.model.Chapter
import ru.startandroid.develop.javatutorial.model.TestScore


@Database(entities = [Chapter::class, TestScore::class], version = 2)
abstract class DatabaseNew : RoomDatabase() {

    abstract fun getChapterDao(): ChapterDao

    companion object {
        @Volatile
        private var instance: ru.startandroid.develop.javatutorial.bd.DatabaseNew? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also {
                instance = it
            }
        }


        private fun createDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            DatabaseNew::class.java,
            "chapter_db.db"
        ).fallbackToDestructiveMigration()
            .build()
    }
}