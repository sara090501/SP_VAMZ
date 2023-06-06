package com.example.kvizzz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

//        val addCategorie: Button = findViewById(R.id.addCategory)
//        addCategorie.setOnClickListener {
//            val intent = Intent(this, AddCategoryFragment::class.java)
//            startActivity(intent)
//        }

        val closeButton: ImageView = findViewById(R.id.exit)
        closeButton.setOnClickListener {
            finish()
        }
    }
}