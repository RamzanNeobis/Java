package ru.startandroid.develop.javatutorial.bd

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MyViewModelFactory(
    private val databaseRepository: DatabaseRepository

    ) : ViewModelProvider.Factory {


    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MyViewModel(databaseRepository) as T
    }
}