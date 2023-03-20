package com.example.mvvm_retrofit_api.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvm_retrofit_api.model.Meme
import com.example.mvvm_retrofit_api.repository.MemeListRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListMemeViewModel(private val repository: MemeListRepository):ViewModel() {
    val listM:MutableLiveData<List<Meme>> = MutableLiveData()
    fun getListMemes() = viewModelScope.launch(Dispatchers.IO) {
        listM.postValue(repository.getListMemes())
    }
}