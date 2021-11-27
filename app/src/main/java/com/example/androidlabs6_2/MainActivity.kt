package com.example.androidlabs6_2

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import java.net.URL
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class MainActivity : AppCompatActivity() {
    private lateinit var image: ImageView
    private lateinit var executorService: ExecutorService
    private val strUrl = "https://krasivye-mesta.ru/img/Palace-Square.jpg"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        image = findViewById<ImageView>(R.id.imageView)
        executorService = Executors.newSingleThreadExecutor()
        executorService.execute {
            val url = URL(strUrl)
            val bitmapPicture = BitmapFactory.decodeStream(url.openConnection().getInputStream())
           runOnUiThread {
                image.setImageBitmap(bitmapPicture)
            }
        }
    }
}