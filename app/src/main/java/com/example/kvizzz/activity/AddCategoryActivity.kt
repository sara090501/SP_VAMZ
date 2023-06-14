package com.example.kvizzz.activity

import CategoryViewModel
import android.content.Context
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.kvizzz.R
import com.example.kvizzz.data.Category
import com.example.kvizzz.data.QuizDatabase
import com.example.kvizzz.databinding.ActivityAddCategoryBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class AddCategoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddCategoryBinding
    private lateinit var categoryViewModel: CategoryViewModel

    private val quizDatabase : QuizDatabase by lazy {
        Room.databaseBuilder(this, QuizDatabase::class.java, "quiz_database")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.exit.setOnClickListener {
            finish()
        }

        binding.apply {
            addCategory.setOnClickListener {
                val name = fillCategoryName

                if (isFieldEmpty(name.text.toString())) {
                    val nameNotFilled: String = getString(R.string.nameNotFilled)
                    name.error = nameNotFilled
                    name.requestFocus()
                }
                else {
                    showFinalAddCategoryDialog()
                }
            }
        }

    }

    private fun insertDataToDatabase() {
        val name = binding.fillCategoryName.text.toString()
        val description = binding.fillCategoryDesctription.text.toString()

        val category = Category(0, name, description)
        categoryViewModel.addCategory(category)
    }

    private fun showFinalAddCategoryDialog() {
        val name: TextView = binding.fillCategoryName

        MaterialAlertDialogBuilder(requireContext())
            .setTitle(getString(R.string.reallyAddCategory, name.text.toString()))
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