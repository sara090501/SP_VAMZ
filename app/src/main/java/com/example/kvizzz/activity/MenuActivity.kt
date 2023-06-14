package com.example.kvizzz.activity

import CategoryViewModel
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kvizzz.data.Category
import com.example.kvizzz.data.CategoryAdapter
import com.example.kvizzz.data.CategoryDao
import com.example.kvizzz.data.CategoryRepository
import com.example.kvizzz.databinding.ActivityMenuBinding

class MenuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMenuBinding
    private lateinit var categoryViewModel: CategoryViewModel
    private val categoryAdapter by lazy { CategoryAdapter() }

    // vytvorenie databazy
//    private val quizDatabase : QuizDatabase by lazy {
//        Room.databaseBuilder(this,QuizDatabase::class.java, "quiz_database")
//            .allowMainThreadQueries()
//            .fallbackToDestructiveMigration()
//            .build()
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        categoryViewModel = ViewModelProvider(this).get(CategoryViewModel::class.java)

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

//        val liveData: LiveData<MutableList<Category>> =
//            categoryViewModel.getAllCategories


        binding.apply {
//            val categoryList: MutableList<Category>? = liveData.value
//            categoryAdapter.differ.submitList(categoryList)
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