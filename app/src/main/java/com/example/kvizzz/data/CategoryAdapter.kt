package com.example.kvizzz.data

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.kvizzz.databinding.CategoryItemBinding

class CategoryAdapter: RecyclerView.Adapter<CategoryAdapter.ViewHolder>(){
    private lateinit var binding: CategoryItemBinding
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        binding = CategoryItemBinding.inflate(inflater, parent, false)
        context = parent.context
        return ViewHolder()
    }

    override fun onBindViewHolder(holder: CategoryAdapter.ViewHolder, position: Int) {
        holder.bind(differ.currentList[position])
        holder.setIsRecyclable(false)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    //vnutorna pomocna trieda na naplnenie RecyclerView
    inner class ViewHolder : RecyclerView.ViewHolder(binding.root) {
        //ztlmenie vynimky
        @SuppressLint("SetTextI18n")
        fun bind(item: Category) {
            binding.apply {
                //nastavenie hodnot v layoute
                itemCategoryName.text = item.name
//                itemCategoryDescription.text = item.description

                //nastavenie co sa ma stat po kliknuti na cvik zo zoznamu
//                root.setOnClickListener {
//                    val intent= Intent(context,WorkoutDetailActivity::class.java)
//                    intent.putExtra("bundle_workout_id", item.id)
//                    context.startActivity(intent)
//                }

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