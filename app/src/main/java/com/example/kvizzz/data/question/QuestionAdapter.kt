package com.example.kvizzz.data.question

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.kvizzz.databinding.QuestionItemBinding

class QuestionAdapter : RecyclerView.Adapter<QuestionAdapter.ViewHolder>(){
    private lateinit var binding: QuestionItemBinding
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        binding = QuestionItemBinding.inflate(inflater, parent, false)
        context = parent.context
        return ViewHolder()

//        binding.question
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
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
        fun bind(item: Question) {
            binding.apply {
                question.text = item.question

                //nastavenie hodnot v layoute
                no.setOnClickListener {

                    if (!item.right) {
                        question.setBackgroundColor(Color.GREEN)
                    } else {
                        question.setBackgroundColor(Color.RED)
                    }

                    yes.setOnClickListener {
                        if (item.right) {
                            question.setBackgroundColor(Color.GREEN)
                        } else {
                            question.setBackgroundColor(Color.RED)
                        }
//
//                itemCategoryName.setOnClickListener {
//                    val intent = Intent(context, CategoryDetailActivity::class.java)
//                    intent.putExtra("category_detail", item.id)
//                    context.startActivity(intent)
//                }

                    }
                }
            }
        }
    }

    private val differCallback = object : DiffUtil.ItemCallback<Question>() {
        override fun areItemsTheSame(oldItem: Question, newItem: Question): Boolean {
            return oldItem.id == newItem.id
        }

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: Question, newItem: Question): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)
}