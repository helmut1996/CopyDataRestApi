package com.example.mvvm_retrofit_api.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvm_retrofit_api.model.Jokes
import com.example.mvvm_retrofit_api.repository.MemesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MemesViewModel(private val memesRepository: MemesRepository): ViewModel() {

    val memes: LiveData<Jokes>

    init {
        viewModelScope.launch(Dispatchers.IO) {
            memesRepository.getMemes()
        }
             memes = memesRepository.memes
    }
}