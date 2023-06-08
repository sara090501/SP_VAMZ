package com.example.kvizzz.viewModel

import android.util.Log

class QuestionViewModel {
    private var _question = "question"
    private var _description = "description"

    init {
        Log.d("QuestionViewModel", "Question $_question created!")
    }

    val question: String
        get() = _question

    val description: String
        get() = _description
}