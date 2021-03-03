package ru.startandroid.develop.javatutorial.model

import android.os.Parcelable
import android.widget.ImageView
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
@Entity(tableName = "chapters")
 data class Chapter(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var nameChapter: String,
    var imageChapter: Int): Serializable, Parcelable