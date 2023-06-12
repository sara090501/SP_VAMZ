package com.example.kvizzz.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.kvizzz.R
import com.example.kvizzz.data.CategoryViewModel

class MenuActivity : AppCompatActivity() {

    private lateinit var categoryRecyclerView: RecyclerView
//    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var categoryViewModel: CategoryViewModel

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

//        categoryRecyclerView = findViewById(R.id.categoryRecyclerView)
//        categoryAdapter = CategoryAdapter() // Initialize with an empty list
//        categoryRecyclerView.adapter = categoryAdapter
//
//        // Initialize your CategoryViewModel and retrieve the data from the Room database
//        categoryViewModel = ViewModelProvider(this).get(CategoryViewModel::class.java)
//        categoryViewModel.getAllCategories().observe(this) { categories ->
//            val updatedCategories = categories ?: emptyList()
//            categoryAdapter.notifyDataSetChanged()
//        }

        val addCategory: Button = findViewById(R.id.addCategory)
        addCategory.setOnClickListener {
            val intent = Intent(this, AddCategoryActivity::class.java)
            startActivity(intent)
        }

        val exit: ImageView = findViewById(R.id.exit)
        exit.setOnClickListener {
            finish()
        }
    }
}