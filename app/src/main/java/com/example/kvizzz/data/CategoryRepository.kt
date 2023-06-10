package com.example.kvizzz.data

import androidx.lifecycle.LiveData

class CategoryRepository(private val categoryDao: CategoryDao) {

    val getAllCategories: LiveData<List<Category>> = categoryDao.getAllCategories()

    fun addCategory(category: Category) {
        categoryDao.addCategory(category)
    }
}