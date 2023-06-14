package com.example.kvizzz.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.kvizzz.data.QuizDatabase
import com.example.kvizzz.data.question.QuestionAdapter
import com.example.kvizzz.databinding.ActivityGameBinding

class GameActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGameBinding
    private val questionAdapter by lazy { QuestionAdapter() }
    var categoryId = 0

    // vytvorenie databazy
    private val quizDatabase : QuizDatabase by lazy {
        Room.databaseBuilder(this, QuizDatabase::class.java, "quiz_database")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        categoryId = intent.getIntExtra("categoryId", 0)

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
            questionAdapter.differ
                .submitList(quizDatabase.questionDao().getAllQuestions(categoryId))
            setupRecyclerView()

            questionRW.canScrollVertically(80)

        }
    }

    private fun setupRecyclerView() {
        binding.questionRW.apply {
            layoutManager = LinearLayoutManager(this@GameActivity)
            adapter = questionAdapter
        }
    }
}