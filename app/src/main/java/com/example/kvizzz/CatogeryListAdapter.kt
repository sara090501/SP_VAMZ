package com.example.kvizzz

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.kvizzz.entity.CategoryEntity


class CategoryListAdapter(diffCallback: DiffUtil.ItemCallback<CategoryEntity?>) :
    ListAdapter<CategoryEntity?, CategoryViewHolder?>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val current: CategoryEntity? = getItem(position)
        if (current != null) {
            holder.bind(current.name)
        }
    }

    internal class WordDiff : DiffUtil.ItemCallback<CategoryEntity>() {
        override fun areItemsTheSame(oldItem: CategoryEntity, newItem: CategoryEntity): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: CategoryEntity, newItem: CategoryEntity): Boolean {
            return oldItem.name == newItem.name
        }
    }
}