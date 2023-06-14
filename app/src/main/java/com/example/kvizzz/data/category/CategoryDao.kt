package com.example.kvizzz.data.category

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CategoryDao {

    @Insert
    fun addCategory(category: Category)

    @Delete
    fun deleteCategory(category: Category)

    @Query("SELECT * FROM category_table ORDER BY name ASC" )
    fun getAllCategories(): MutableList<Category>

    @Query("SELECT * FROM category_table WHERE id LIKE :id")
    fun getCategory(id: Int) : Category
}