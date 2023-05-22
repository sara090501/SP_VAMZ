package com.example.kvizzz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    var isImageExpanded = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val logo: ImageView = findViewById(R.id.logo);
        val playButton: Button = findViewById(R.id.play)
        playButton.setOnClickListener {
            if (isImageExpanded) {
                // Reduce the image size
                val layoutParams = logo.layoutParams
                layoutParams.width /= 2
                layoutParams.height /= 2
                logo.layoutParams = layoutParams
            } else {
                // Increase the image size
                val layoutParams = logo.layoutParams
                layoutParams.width *= 2
                layoutParams.height *= 2
                logo.layoutParams = layoutParams
            }

            isImageExpanded = !isImageExpanded
        }
    }
}