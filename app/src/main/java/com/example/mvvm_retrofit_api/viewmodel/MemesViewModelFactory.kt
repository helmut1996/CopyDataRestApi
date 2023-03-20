package com.example.mvvm_retrofit_api.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm_retrofit_api.repository.MemesRepository

class MemesViewModelFactory(private val memesRepository: MemesRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MemesViewModel(memesRepository) as T
    }
}