package com.example.mvvm_retrofit_api.Room

import androidx.room.Dao
import androidx.room.Query
import com.example.mvvm_retrofit_api.model.Meme

@Dao
interface MemeListDao {
    @Query("SELECT * FROM memes")
    suspend fun getMemes() : List<Meme>
}
