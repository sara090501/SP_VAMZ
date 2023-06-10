package com.example.kvizzz

import android.R

import android.view.LayoutInflater
import android.view.View

import android.view.ViewGroup

import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView


//class CategoryViewHolder private constructor(itemView: View) :
//    RecyclerView.ViewHolder(itemView) {
//    private val categoryItemView: TextView
//
//    init {
//        categoryItemView = itemView.findViewById(R.id.textView)
//    }
//
//    fun bind(text: String?) {
//        categoryItemView.text = text
//    }
//
//    companion object {
//        fun create(parent: ViewGroup): CategoryViewHolder {
//            val view: View = LayoutInflater.from(parent.context)
//                .inflate(R.layout.activity_list_item, parent, false)
//            return CategoryViewHolder(view)
//        }
//    }
//}