package com.example.mvvm_retrofit_api.Utils

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build

class MyUtils {

    companion object{
        @SuppressLint("MissingPermission")
        fun isInternetAvailable(context:Context): Boolean{
            (context.getSystemService(Context.CONNECTIVITY_SERVICE)as ConnectivityManager).run {
                if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.M){
                   return  this.getNetworkCapabilities(this.activeNetwork)?.hasCapability(
                       NetworkCapabilities.NET_CAPABILITY_INTERNET
                   )?: false
                }else{
                    return  this.activeNetworkInfo?.isConnected ?: false
                }
            }
        }
    }
}