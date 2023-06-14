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
import java.util.Arrays

// kod inspirovany strankou developer.android.com
class QuestionAdapter : RecyclerView.Adapter<QuestionAdapter.ViewHolder>(){
    private lateinit var binding: QuestionItemBinding
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        binding = QuestionItemBinding.inflate(inflater, parent, false)
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

    //vnutorna pomocna trieda na naplnenie RecyclerView
    inner class ViewHolder : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(item: Question) {
            binding.apply {
                // vypis hodnot z databazy do layout
                question.text = item.question

                // vytvorenie farieb pre spravnost odpovede
                val green: Int = Color.rgb(51, 204, 51)
                val red: Int = Color.rgb(255, 102, 102)

                // ak pouzivatel stacil tlacidlo nie
                no.setOnClickListener {
                    // ak je spravna odpoved nie, otazka sa zozeleni, inak ocerveni
                    if (!item.right) {
                        question.setBackgroundColor(green)
                    } else {
                        question.setBackgroundColor(red)
                    }

                    // znefunkcnenie tlacidiel
                    no.isEnabled = false
                    yes.isEnabled = false
                }

                yes.setOnClickListener {
                    // ak je spravna odpoved ano, otazka sa zozeleni, inak ocerveni
                    if (item.right) {
                        question.setBackgroundColor(green)
                    } else {
                        question.setBackgroundColor(red)
                    }

                    // znefunkcnenie tlacidiel
                    no.isEnabled = false
                    yes.isEnabled = false
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