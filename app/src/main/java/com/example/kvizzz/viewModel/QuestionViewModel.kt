package com.example.kvizzz.viewModel

import android.util.Log

class QuestionViewModel {
    private var _question = "question"
    private var _responses: MutableList<ResponseViewModel> = mutableListOf()

    init {
        Log.d("QuestionViewModel", "Question $_question created!")
    }

    val question: String
        get() = _question

    val responses: MutableList<ResponseViewModel>
        get() = _responses
}