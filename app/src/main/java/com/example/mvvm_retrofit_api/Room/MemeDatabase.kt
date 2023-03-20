package com.example.mvvm_retrofit_api.Room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mvvm_retrofit_api.model.Meme

@Database(entities = [Meme::class], version = 1)
abstract class MemeDatabase:RoomDatabase() {

    abstract fun memeDao():RoomDao
    companion object{
        private var INSTANCE: MemeDatabase? = null

       fun getDatabase(context: Context):MemeDatabase{
            if (INSTANCE == null){
                Room.databaseBuilder(
                    context,
                    MemeDatabase::class.java,
                    "memesDB"
                ).build().also { INSTANCE = it }
            }

            return  INSTANCE!!
        }

    }
}