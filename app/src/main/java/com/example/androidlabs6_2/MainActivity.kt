package com.example.androidlabs6_2

import android.app.Application
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import java.net.URL
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.Future

class MainActivity : AppCompatActivity() {
    private lateinit var image: ImageView
    private lateinit var futureBackground: Future<*>
    private val strUrl = "https://krasivye-mesta.ru/img/Palace-Square.jpg"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        image = findViewById<ImageView>(R.id.imageView)
    }

    override fun onStart() {
        super.onStart()
        futureBackground = (applicationContext as ForExecutor).executor.submit {
            while (!futureBackground.isCancelled) {
                val url = URL(strUrl)
                val bitmapPicture =
                    BitmapFactory.decodeStream(url.openConnection().getInputStream())
                runOnUiThread {
                    image.setImageBitmap(bitmapPicture)
                }
            }
        }
    }

    override fun onStop() {
        super.onStop()
        futureBackground.cancel(true)
    }
}

class ForExecutor: Application() {
    val executor: ExecutorService = Executors.newSingleThreadExecutor()
}