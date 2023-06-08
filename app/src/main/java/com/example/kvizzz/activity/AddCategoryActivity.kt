package com.example.kvizzz.activity

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.kvizzz.R

class AddCategoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_category)

        val exit: ImageView = findViewById(R.id.exit)
        exit.setOnClickListener {
            finish()
        }
    }
}