package com.example.kvizzz.activity

import android.content.Context
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.kvizzz.R
import com.example.kvizzz.data.QuizDatabase
import com.example.kvizzz.data.question.Question
import com.example.kvizzz.databinding.ActivityAddQuestionBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class AddQuestionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddQuestionBinding
    var categoryId = 0
    var right = false

    private val quizDatabase : QuizDatabase by lazy {
        Room.databaseBuilder(this, QuizDatabase::class.java, "quiz_database")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddQuestionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        categoryId = intent.getIntExtra("categoryId", 0)

        binding.exit.setOnClickListener {
            finish()
        }

        binding.apply {
            addQuestion.setOnClickListener {
                val question = fillQuestion

                if (decisionRW.checkedRadioButtonId == yesDecision.id) {
                    right = true
                }

                if (isFieldEmpty(question.text.toString())) {
                    val nameNotFilled: String = getString(R.string.nameNotFilled)
                    question.error = nameNotFilled
                    question.requestFocus()
                }
                else if (decisionRW.checkedRadioButtonId == -1) {
                    notDecided()
                } else {
                    showFinalAddQuestionDialog()
                }
            }
        }
    }

    private fun notDecided() {
        MaterialAlertDialogBuilder(requireContext())
            .setTitle(getString(R.string.noDecision))
            .setCancelable(true)
            .setPositiveButton(getString(R.string.ok)) { _, _ ->
                closeContextMenu()
            }
            .show()
    }

    private fun insertDataToDatabase() {
        val name = binding.fillQuestion.text.toString()
        val question = Question(0, categoryId, name, right)
        quizDatabase.questionDao().addQuestion(question)
    }

    private fun showFinalAddQuestionDialog() {
        val question: TextView = binding.fillQuestion

        MaterialAlertDialogBuilder(requireContext())
            .setTitle(getString(R.string.reallyAddQuestion, question.text.toString()))
            .setCancelable(false)
            .setPositiveButton(getString(R.string.yesAddCategory)) { _, _ ->
                insertDataToDatabase()
                closeContextMenu()
                finish()
            }
            .setNegativeButton(getString(R.string.noAddCategory)) { _, _ ->
                closeContextMenu()
            }
            .show()
    }

    private fun isFieldEmpty(text: String): Boolean {
        if (text.equals("", true)) {
            return true
        }
        return false
    }

    private fun requireContext(): Context {
        return this
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}