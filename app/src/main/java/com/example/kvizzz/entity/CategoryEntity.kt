package com.example.kvizzz.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "category")
class CategoryEntity {
    @PrimaryKey(autoGenerate = true)
    var id = 1
    @ColumnInfo(name = "name")
    var name = "category"
    @ColumnInfo(name = "description")
    var description = "description"
    @ColumnInfo(name = "added")
    var added = false


//    @ColumnInfo()
//    private var _questions: MutableList<QuestionViewModel> = mutableListOf()
}