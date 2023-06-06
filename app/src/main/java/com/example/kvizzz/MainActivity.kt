package com.example.kvizzz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val playButton: Button = findViewById(R.id.play)
        playButton.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }

        val closeButton: ImageView = findViewById(R.id.exit)
        closeButton.setOnClickListener {
            onDestroy()
        }

    }

    override fun onDestroy() {
        super.onDestroy()
    }
}