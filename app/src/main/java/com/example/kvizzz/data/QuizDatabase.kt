package com.example.kvizzz.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Category::class], version = 1, exportSchema = false)
abstract class QuizDatabase: RoomDatabase() {
    abstract fun categoryDao(): CategoryDao
}