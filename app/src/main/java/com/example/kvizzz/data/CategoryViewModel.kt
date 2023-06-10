package com.example.kvizzz.data

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.kvizzz.viewModel.QuestionViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CategoryViewModel(application: Application) : AndroidViewModel(application) {

    private val getAllCategories: LiveData<List<Category>>
    private val repository: CategoryRepository

    init {
        val categoryDao = QuizDatabase.getDatabase(application).categoryDao()
        repository = CategoryRepository(categoryDao)
        getAllCategories = repository.getAllCategories

    }

    fun addCategory(category: Category) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addCategory(category)
        }
    }

}