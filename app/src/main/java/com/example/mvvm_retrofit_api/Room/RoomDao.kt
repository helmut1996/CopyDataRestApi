package com.example.mvvm_retrofit_api.Room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mvvm_retrofit_api.model.Meme

@Dao
interface RoomDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMemes(meme: List<Meme>)

    @Query("SELECT * FROM memes")
    suspend fun getMemes() : List<Meme>

}