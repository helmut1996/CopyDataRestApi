package com.example.mvvm_retrofit_api.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "memes")
data class Meme (
    val  box_count : Int,
    val heigth:Int,
    @PrimaryKey
    val id:Int,
    val name:String,
    val url:String,
    val width:Int
)