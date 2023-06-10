package com.example.kvizzz.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.kvizzz.repository.CategoryRepository

class CategoryViewModel(application: Application) : ViewModel() {
    private var _name = "category"
    private var _description = "description"
    private var _added = false
    private var _questions: MutableList<QuestionViewModel> = mutableListOf()
    private val mRepository: CategoryRepository

    init {
        mRepository = CategoryRepository(application)
        Log.d("CategoryViewModel", "Category $_name created!")
    }

    val name: String
        get() = _name

    val description: String
        get() = _description

    val added: Boolean
        get() = _added

    val questions: MutableList<QuestionViewModel>
        get() = _questions

    private fun addCategory() {
        _added = true
    }

}