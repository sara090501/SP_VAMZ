package com.example.kvizzz.viewModel

import android.util.Log

class ResponseViewModel {
    private var _response = "response"
    private var _right = false

    init {
        Log.d("CategoryViewModel", "Category $_response created!")
    }

    val name: String
        get() = _response

    val right: Boolean
        get() = _right
}