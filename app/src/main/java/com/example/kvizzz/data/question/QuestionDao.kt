package com.example.kvizzz.data.question

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface QuestionDao {

    @Insert
    fun addQuestion(question: Question)

    @Delete
    fun deleteCategory(question: Question)

    @Query("SELECT * FROM question_table WHERE category_id = :id" )
    fun getAllQuestions(id: Int): MutableList<Question>

    @Query("SELECT * FROM question_table WHERE id LIKE :id")
    fun getCategory(id: Int) : Question

}