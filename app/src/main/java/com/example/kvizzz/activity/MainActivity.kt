package com.example.kvizzz.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.example.kvizzz.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val playButton: Button = findViewById(R.id.play)
        playButton.setOnClickListener {
            val intent = Intent(this@MainActivity, MenuActivity::class.java)
            startActivity(intent)
        }

        val exit: ImageView = findViewById(R.id.exit)
        exit.setOnClickListener {
            onDestroy()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}