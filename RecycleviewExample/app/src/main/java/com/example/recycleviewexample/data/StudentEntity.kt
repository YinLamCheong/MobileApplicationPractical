package com.example.recycleviewexample.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "StudentTable")
data class StudentEntity (
    @PrimaryKey(autoGenerate = true)
    val id:Int,

    val name:String,

    val programme:String
    )