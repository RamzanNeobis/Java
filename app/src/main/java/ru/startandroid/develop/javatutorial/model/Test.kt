package ru.startandroid.develop.javatutorial.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.io.Serializable



class Test(var id: Int, var nameTest: String)