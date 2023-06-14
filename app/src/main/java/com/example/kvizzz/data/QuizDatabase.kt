package com.example.kvizzz.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.kvizzz.data.category.Category
import com.example.kvizzz.data.category.CategoryDao
import com.example.kvizzz.data.question.Question
import com.example.kvizzz.data.question.QuestionDao

@Database(entities = [Category::class, Question::class], version = 2, exportSchema = false)
abstract class QuizDatabase: RoomDatabase() {
    abstract fun categoryDao(): CategoryDao
    abstract fun questionDao(): QuestionDao
}