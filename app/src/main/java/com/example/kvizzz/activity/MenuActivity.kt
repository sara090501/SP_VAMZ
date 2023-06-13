package com.example.kvizzz.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.kvizzz.R
import com.example.kvizzz.data.CategoryViewModel
import com.example.kvizzz.data.QuizDatabase
import com.example.kvizzz.databinding.ActivityMenuBinding

class MenuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMenuBinding
    private lateinit var categoryViewModel: CategoryViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        binding.addCategory.setOnClickListener(
//            val intent = Intent(this, AddCategoryActivity::class.java)
//            startActivity(intent)
//        )

        val addCategory: Button = findViewById(R.id.addCategory)
        addCategory.setOnClickListener {
            val intent = Intent(this, AddCategoryActivity::class.java)
            startActivity(intent)
        }

        binding.exit.setOnClickListener {
            finish()
        }

//        //nacitanie zoznamu po opetovnom prichode do aktivity
//        override fun onResume() {
//            super.onResume()
//            checkItem()
//        }
    }
}