package com.example.mvvm_retrofit_api.Utils

import android.app.Application
import com.example.mvvm_retrofit_api.Room.MemeDatabase
import com.example.mvvm_retrofit_api.api.ApiInterface
import com.example.mvvm_retrofit_api.api.ApiUtilies
import com.example.mvvm_retrofit_api.repository.MemesRepository

class MyApplication:Application() {

    lateinit var memesRepository: MemesRepository

    override fun onCreate() {
        super.onCreate()

        val apiInterface= ApiUtilies.getinterface().create(ApiInterface::class.java)
        val database = MemeDatabase.getDatabase(applicationContext)

         memesRepository = MemesRepository(apiInterface,database,applicationContext)
    }
}