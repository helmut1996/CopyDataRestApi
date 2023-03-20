package com.example.mvvm_retrofit_api.api

import com.example.mvvm_retrofit_api.model.Jokes
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface  {
    @GET("get_memes")

    suspend fun getJokes():Response<Jokes>
}