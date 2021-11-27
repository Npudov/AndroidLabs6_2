package com.example.androidlabs6_2

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Library: AppCompatActivity() {
    private lateinit var image: ImageView
    private val strUrl = "https://krasivye-mesta.ru/img/Palace-Square.jpg"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        image = findViewById<ImageView>(R.id.imageView)
        CoroutineScope(Dispatchers.IO).launch {
            runOnUiThread {
                Glide.with(this@Library).load(strUrl).into(image)
            }
        }
    }
}