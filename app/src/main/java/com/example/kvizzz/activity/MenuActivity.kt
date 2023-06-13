package com.example.kvizzz.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.kvizzz.data.CategoryAdapter
import com.example.kvizzz.data.QuizDatabase
import com.example.kvizzz.databinding.ActivityMenuBinding

class MenuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMenuBinding
    private val categoryAdapter by lazy { CategoryAdapter() }

    // vytvorenie databazy
    private val quizDatabase : QuizDatabase by lazy {
        Room.databaseBuilder(this,QuizDatabase::class.java, "quiz_database")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.addCategory.setOnClickListener {
            val intent = Intent(this, AddCategoryActivity::class.java)
            startActivity(intent)
        }

        binding.exit.setOnClickListener {
            finish()
        }
    }

    //nacitanie zoznamu po opetovnom prichode do aktivity
    override fun onResume() {
        super.onResume()
        checkItem()
    }

    private fun checkItem() {
        binding.apply {
            categoryAdapter.differ.submitList(quizDatabase.categoryDao().getAllCategories())
            setupRecyclerView()

            categoryRecyclerView.canScrollVertically(1)
        }
    }

    private fun setupRecyclerView() {
        binding.categoryRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@MenuActivity)
            adapter = categoryAdapter
        }
    }
}