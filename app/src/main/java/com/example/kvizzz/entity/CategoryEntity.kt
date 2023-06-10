package com.example.kvizzz.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "category")
class CategoryEntity {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private var _id = 1
    @ColumnInfo(name = "name")
    private var _name = "category"
    @ColumnInfo(name = "description")
    private var _description = "description"
    @ColumnInfo(name = "added")
    private var _added = false

    val name: String
        get() {
            return _name;
        }

    val description: String
        get() {
            return _description;
        }

    val added: Boolean
        get() {
            return _added;
        }
//    @ColumnInfo()
//    private var _questions: MutableList<QuestionViewModel> = mutableListOf()
}