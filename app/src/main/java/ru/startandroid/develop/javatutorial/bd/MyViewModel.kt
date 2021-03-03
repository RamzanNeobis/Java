package ru.startandroid.develop.javatutorial.bd

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.startandroid.develop.javatutorial.model.Chapter
import ru.startandroid.develop.javatutorial.model.TestScore

class MyViewModel(private val databaseRepository: DatabaseRepository) : ViewModel() {



    fun getSavedChapters() = databaseRepository.getSavedChapters()

    fun saveChapter(chapter: Chapter) = viewModelScope.launch {
        databaseRepository.insert(chapter)
    }

    fun deleteChapter(chapter: Chapter) = viewModelScope.launch {
        databaseRepository.delete(chapter)
    }

     fun getSavedScores() = databaseRepository.getSavedScores()

     fun saveScore(score: TestScore) = viewModelScope.launch {
         databaseRepository.insertScore(score)
     }

     fun deleteScore(score: TestScore) = viewModelScope.launch {
         databaseRepository.deleteScore(score)
     }

    fun updateScore(score: TestScore) = viewModelScope.launch {
        databaseRepository.updateScore(score)
    }

}