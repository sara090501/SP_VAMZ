package com.example.kvizzz.activity

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.kvizzz.R
import com.example.kvizzz.databinding.ActivityAddQuestionBinding
import com.example.kvizzz.databinding.ActivityMenuBinding

class AddQuestionActivity : AppCompatActivity() {

    private lateinit var binding : ActivityAddQuestionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddQuestionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.exit.setOnClickListener {
            finish()
        }

//        binding.addQuestion.setOnClickListener {
//            val intent = Intent(this, AddQuestionActivity::class.java)
//            startActivity(intent)
//        }
    }
}