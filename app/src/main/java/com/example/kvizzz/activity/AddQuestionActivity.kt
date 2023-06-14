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

    // vytvorenie databazy
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

        // priadenia idcka danej kategorie, v ktorom sa otazka nachadza
        categoryId = intent.getIntExtra("categoryId", 0)

        binding.exit.setOnClickListener {
            finish()
        }

        binding.apply {
            addQuestion.setOnClickListener {
                val question = fillQuestion

                //na zaklade zvolenej odpovede sa do databazy ulozi spravnost
                if (decisionRW.checkedRadioButtonId == yesDecision.id) {
                    right = true
                }

                // osetrenie prazdnej otazky
                if (isFieldEmpty(question.text.toString())) {
                    val nameNotFilled: String = getString(R.string.nameNotFilled)
                    question.error = nameNotFilled
                    question.requestFocus()
                }
                //osetrenie vyberu spravnosti
                else if (decisionRW.checkedRadioButtonId == -1) {
                    notDecided()
                } else {
                    showFinalAddQuestionDialog()
                }
            }
        }
    }

    private fun notDecided() {
        // dialogove okno, ktore informuje o tom, ze pouzivatej nevybral,
        // co bude pri otazke spravna odpoved
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
        // vytvorenie otazky na zaklade parametrov a nasledne ulozenie do databazy
        val question = Question(0, categoryId, name, right)
        quizDatabase.questionDao().addQuestion(question)
    }

    private fun showFinalAddQuestionDialog() {
        val question: TextView = binding.fillQuestion

        // rozhodutie, ci chceme alebo nechceme otazku pridat do databazy
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