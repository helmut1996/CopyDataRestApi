package com.example.mvvm_retrofit_api.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm_retrofit_api.repository.MemeListRepository

class ListMemesFactory(private val repository: MemeListRepository):ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ListMemeViewModel(repository)as T
    }

}