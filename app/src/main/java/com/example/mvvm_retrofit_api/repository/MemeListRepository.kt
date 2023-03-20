package com.example.mvvm_retrofit_api.repository

import com.example.mvvm_retrofit_api.Room.MemeListDao

class MemeListRepository(private val dao: MemeListDao) {
    suspend fun getListMemes()= dao.getMemes()

}