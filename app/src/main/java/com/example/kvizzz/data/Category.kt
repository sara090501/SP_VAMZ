package com.example.kvizzz.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "category_table")
class Category(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val description: String)