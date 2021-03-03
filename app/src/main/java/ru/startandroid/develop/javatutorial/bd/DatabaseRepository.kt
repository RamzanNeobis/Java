package ru.startandroid.develop.javatutorial.bd


import ru.startandroid.develop.javatutorial.model.Chapter
import ru.startandroid.develop.javatutorial.model.TestScore

class DatabaseRepository(private val db: DatabaseNew) {

    suspend fun insert(chapter: Chapter) {
        db.getChapterDao().insert(chapter)
    }

    suspend fun delete(chapter: Chapter) {
        db.getChapterDao().delete(chapter)
    }

    fun getSavedChapters() = db.getChapterDao().getAllChapters()

    suspend fun insertScore(score: TestScore) {
        db.getChapterDao().insertScore(score)
    }

    suspend fun deleteScore(score: TestScore) {
        db.getChapterDao().deleteScore(score)
    }

    fun getSavedScores() = db.getChapterDao().getAllScores()

    suspend fun updateScore(score: TestScore){
        db.getChapterDao().updateScore(score)
    }





}