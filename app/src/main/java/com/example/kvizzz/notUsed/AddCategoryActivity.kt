//package com.example.kvizzz.notUsed
//
//import android.content.Context
//import android.os.Bundle
//import android.widget.Button
//import android.widget.ImageView
//import android.widget.TextView
//import androidx.appcompat.app.AppCompatActivity
//import androidx.lifecycle.ViewModelProvider
//import com.example.kvizzz.R
//import com.example.kvizzz.data.Category
//import com.example.kvizzz.data.CategoryViewModel
//import com.google.android.material.dialog.MaterialAlertDialogBuilder
//
//class AddCategoryActivity : AppCompatActivity() {
//
//    private lateinit var categoryViewModel: CategoryViewModel
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_add_category)
//
//        val exit: ImageView = findViewById(R.id.exit)
//        exit.setOnClickListener {
//            finish()
//        }
//
//        val name: TextView = findViewById(R.id.fillCategoryName)
//
//        val addCategory: Button = findViewById(R.id.addCategory)
//        addCategory.setOnClickListener {
//            if (isFieldEmpty(name.text.toString())) {
//                val nameNotFilled: String = getString(R.string.nameNotFilled)
//                name.error = nameNotFilled
//                name.requestFocus()
//            }
//            else {
//                showFinalAddCategoryDialog()
//            }
//        }
//    }
//
//    private fun insertDataToDatabase() {
//        val name: TextView = findViewById(R.id.fillCategoryName)
//        val description: TextView = findViewById(R.id.fillCategoryDesctription)
//
//        val category = Category(0, name.text.toString(), description.text.toString())
//        categoryViewModel.addCategory(category)
//    }
//
//    private fun showFinalAddCategoryDialog() {
//        MaterialAlertDialogBuilder(requireContext())
//            .setTitle(getString(R.string.reallyAddCategory, "bla bla"))
//            .setCancelable(false)
//            .setPositiveButton(getString(R.string.yesAddCategory)) { _, _ ->
//                categoryViewModel = ViewModelProvider(this).get(CategoryViewModel::class.java)
//                insertDataToDatabase()
//                closeContextMenu()
//                finish()
//            }
//            .setNegativeButton(getString(R.string.noAddCategory)) { _, _ ->
//                closeContextMenu()
//            }
//            .show()
//    }
//
//    private fun errorDialog() {
//        MaterialAlertDialogBuilder(requireContext())
//            .setTitle(getString(R.string.nameNotFilled))
//            .setCancelable(true)
//            .setNegativeButton(getString(R.string.ok)) { _, _ ->
//                finish()
//            }
//            .show()
//    }
//
//    private fun isFieldEmpty(text: String): Boolean {
//        if (text.equals("", true)) {
//            return true
//        }
//        return false
//    }
//
//    private fun requireContext(): Context {
//        return this
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//    }
//}