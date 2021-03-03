package ru.startandroid.develop.javatutorial.bd

import androidx.lifecycle.LiveData
import androidx.room.*
import ru.startandroid.develop.javatutorial.model.Chapter
import ru.startandroid.develop.javatutorial.model.TestScore


@Dao
interface ChapterDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(chapter: Chapter)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertScore(score: TestScore)

    @Query("SELECT * FROM chapters")
    fun getAll(): List<Chapter>

    @Query("SELECT * FROM score")
    fun getAllScore(): List<TestScore>


    @Query("SELECT * FROM chapters")
    fun getAllChapters(): LiveData<List<Chapter>>

    @Query("SELECT * FROM score")
    fun getAllScores(): LiveData<List<TestScore>>

    @Delete
    suspend fun delete(chapter: Chapter)

    @Delete
    suspend fun deleteScore(score: TestScore)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateScore(score: TestScore)
}