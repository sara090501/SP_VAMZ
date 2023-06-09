package com.example.kvizzz

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.kvizzz.entity.CategoryEntity

@Dao
abstract class QuizDatabaseDao {
    @Insert
    abstract fun insert(night: CategoryEntity)

    @Update
    fun update(night: CategoryEntity) {
    }

    @Query("SELECT * FROM category ORDER BY id DESC LIMIT 1")
    abstract fun get(id: Long): CategoryEntity?
}