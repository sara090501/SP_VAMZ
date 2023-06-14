package com.example.kvizzz.data.category

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.kvizzz.activity.CategoryDetailActivity
import com.example.kvizzz.databinding.CategoryItemBinding

// kod inspirovany strankou developer.android.com
class CategoryAdapter: RecyclerView.Adapter<CategoryAdapter.ViewHolder>(){
    private lateinit var binding: CategoryItemBinding
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        binding = CategoryItemBinding.inflate(inflater, parent, false)
        context = parent.context
        return ViewHolder()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(differ.currentList[position])
        holder.setIsRecyclable(false)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    // vnutorna pomocna trieda na naplnenie RecyclerView
    inner class ViewHolder : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(item: Category) {
            binding.apply {
                // vypis hodnot z databazy do layout
                itemCategoryName.text = item.name

                // presun do detailu kategorie po kliknuti na tlacitdlo danej kategorie
                itemCategoryName.setOnClickListener {
                    val intent = Intent(context, CategoryDetailActivity::class.java)

                    // definicia id kategorie pre dalsie pracovanie v detaile
                    intent.putExtra("category_detail", item.id)
                    context.startActivity(intent)
                }
            }
        }
    }

    private val differCallback = object : DiffUtil.ItemCallback<Category>() {
        override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean {
            return oldItem.id == newItem.id
        }

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)
}