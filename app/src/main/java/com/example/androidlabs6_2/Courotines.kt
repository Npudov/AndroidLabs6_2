package com.example.androidlabs6_2

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class Courotines: AppCompatActivity() {
    private lateinit var image: ImageView
    val viewModelExample = ViewModelClass()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        image = findViewById<ImageView>(R.id.imageView)

    }

    override fun onStart() {
        super.onStart()
        viewModelExample.liveData.observe(this) {
            if (viewModelExample.liveData.value != null) {
                image.setImageBitmap(viewModelExample.liveData.value)
            }
        }
        viewModelExample.getImageInternet()
    }
}