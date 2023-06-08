package com.example.kvizzz.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel

class CategoryViewModel : ViewModel() {
    private var _name = "category"
    private var _description = "description"

    init {
        Log.d("CategoryViewModel", "Category $_name created!")
    }

    val name: String
        get() = _name

    val description: String
        get() = _description
}