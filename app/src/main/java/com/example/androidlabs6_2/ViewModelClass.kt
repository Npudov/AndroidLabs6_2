package com.example.androidlabs6_2

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.URL

class ViewModelClass: ViewModel() {
    private val strUrl = "https://krasivye-mesta.ru/img/Palace-Square.jpg"
    val liveData = MutableLiveData<Bitmap>()
    fun getImageInternet() {
        viewModelScope.launch(Dispatchers.IO) {
            val url = URL(strUrl)
            val bitmapPicture = BitmapFactory.decodeStream(url.openConnection().getInputStream())
            withContext(Dispatchers.Main) {
                liveData.value = bitmapPicture
            }
        }
    }
}