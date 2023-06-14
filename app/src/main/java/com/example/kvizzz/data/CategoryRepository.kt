package com.example.kvizzz.data

import androidx.lifecycle.LiveData

class CategoryRepository(private val categoryDao: CategoryDao) {

    fun getAllCategories(): LiveData<MutableList<Category>> {
        return categoryDao.getAllCategories()
    }

    suspend fun getCategory(id: Int) {
        categoryDao.getCategory(id)
    }

    suspend fun addCategory(category: Category) {
        categoryDao.addCategory(category)
    }

    suspend fun deleteCategory(category: Category) {
        categoryDao.deleteCategory(category)
    }
}