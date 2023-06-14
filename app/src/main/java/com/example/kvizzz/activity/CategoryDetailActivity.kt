package com.example.kvizzz.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.kvizzz.data.QuizDatabase
import com.example.kvizzz.data.category.Category
import com.example.kvizzz.databinding.ActivityCategoryDetailBinding

class CategoryDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCategoryDetailBinding
    private var categoryId = 0
    private lateinit var categoryEntity: Category

    // vytvorenie databazy
    private val quizDatabase : QuizDatabase by lazy {
        Room.databaseBuilder(this, QuizDatabase::class.java, "quiz_database")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.exit.setOnClickListener {
            finish()
        }

        // urcenie id kategorie pomocou mapovacieho kluca
        intent.extras?.let {
            categoryId = it.getInt("category_detail")
        }

        binding.apply {
            // vykreslenie textu na zaklade dat z db
            nameOfCategory.text =
                quizDatabase.categoryDao().getCategory(categoryId).name
            categoryDescription.text =
                quizDatabase.categoryDao().getCategory(categoryId).description

            // prechod do pridania kategorie pomocou tlacidla
            binding.addQuestion.setOnClickListener {
                val intent = Intent(this@CategoryDetailActivity,
                    AddQuestionActivity::class.java)
                intent.putExtra("categoryId", categoryId)
                startActivity(intent)
            }

            // spustenie kvizu pomocou tlacidla
            binding.play.setOnClickListener {
                val intent = Intent(this@CategoryDetailActivity,
                    GameActivity::class.java)
                intent.putExtra("categoryId", categoryId)
                startActivity(intent)
            }

            // odstranenie kategorie pomocou tlacidla
            binding.removeCategory.setOnClickListener {
                categoryEntity = quizDatabase.categoryDao().getCategory(categoryId)
                quizDatabase.categoryDao().deleteCategory(categoryEntity)
                finish()
            }
        }
    }
}