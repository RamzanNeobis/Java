package ru.startandroid.develop.javatutorial.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
@Entity(tableName = "score")
data class TestScore(
    @PrimaryKey(autoGenerate = true)
    val scoreId: Int,
    val nameScore: String,
    val totalScore: Int,
    val correctAnswer: Int): Serializable, Parcelable