package com.example.kvizzz.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CategoryDao {

    @Insert
    fun addCategory(category: Category)

    @Query("SELECT * FROM category_table ORDER BY name ASC" )
    fun getAllCategories(): MutableList<Category>

    @Query("SELECT * FROM category_table WHERE id LIKE :id")
    fun getCategory(id: Int) : Category
}