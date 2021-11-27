package com.example.androidlabs6_2

import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.net.URL


class Courotines: AppCompatActivity() {
    private lateinit var image: ImageView
    private val strUrl = "https://krasivye-mesta.ru/img/Palace-Square.jpg"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        image = findViewById<ImageView>(R.id.imageView)
        CoroutineScope(Dispatchers.IO).launch {
            val url = URL(strUrl)
            val bitmapPicture = BitmapFactory.decodeStream(url.openConnection().getInputStream())
            runOnUiThread {
                image.setImageBitmap(bitmapPicture)
            }
        }
    }
}