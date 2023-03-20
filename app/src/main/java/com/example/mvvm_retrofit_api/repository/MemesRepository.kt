package com.example.mvvm_retrofit_api.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvm_retrofit_api.Room.MemeDatabase
import com.example.mvvm_retrofit_api.Utils.MyUtils
import com.example.mvvm_retrofit_api.api.ApiInterface
import com.example.mvvm_retrofit_api.model.Data
import com.example.mvvm_retrofit_api.model.Jokes

class MemesRepository(
    private val apiInterface: ApiInterface,
    private val memeDatabase: MemeDatabase,
   private val applicationContext: Context
) {
    private val memesLiveData= MutableLiveData<Jokes>()
    val memes: LiveData<Jokes> get() = memesLiveData

    suspend fun getMemes(){

        if (MyUtils.isInternetAvailable(applicationContext)){

            val result = apiInterface.getJokes()
            if (result.body() != null){

                memeDatabase.memeDao().insertMemes(result.body()!!.data.memes)

                memesLiveData.postValue(result.body())
            }

        }else{

            val memes = memeDatabase.memeDao().getMemes()

            val memeList= Jokes(Data(memes), success = true)

            memesLiveData.postValue(memeList)
        }




    }
}