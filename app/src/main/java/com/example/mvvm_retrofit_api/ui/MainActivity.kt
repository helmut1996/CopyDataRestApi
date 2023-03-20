package com.example.mvvm_retrofit_api.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm_retrofit_api.R
import com.example.mvvm_retrofit_api.Utils.MyApplication
import com.example.mvvm_retrofit_api.viewmodel.ListMemeViewModel
import com.example.mvvm_retrofit_api.viewmodel.ListMemesFactory
import com.example.mvvm_retrofit_api.viewmodel.MemesViewModel
import com.example.mvvm_retrofit_api.viewmodel.MemesViewModelFactory

class MainActivity : AppCompatActivity() {
   private lateinit var memesViewModel: MemesViewModel
//   private lateinit var listmemeviewmodel: ListMemeViewModel
  // private lateinit var factoryList:ListMemesFactory



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository =(application as MyApplication).memesRepository
        memesViewModel = ViewModelProvider(this,MemesViewModelFactory(repository)).get(MemesViewModel::class.java)

        memesViewModel.memes.observe(this,{

            Toast.makeText(this,"zise: ${it.data.memes.size}",Toast.LENGTH_SHORT).show()

            it.data.memes.iterator().forEach { meme->
                Log.d("Result:", "onCreate: ${meme.name} \n url: ${meme.url}")
            }

        })

    }
}