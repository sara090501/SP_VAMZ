package com.example.kvizzz.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CategoryViewModel(application: Application) : AndroidViewModel(application) {

    private val _getAllCategories: LiveData<List<Category>>
    private val repository: CategoryRepository

    init {
        val categoryDao = QuizDatabase.getDatabase(application).categoryDao()
        repository = CategoryRepository(categoryDao)
        _getAllCategories = repository.getAllCategories

    }

    fun addCategory(category: Category) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addCategory(category)
        }
    }

    fun getAllCategories(): LiveData<List<Category>> {
        return _getAllCategories
    }
}