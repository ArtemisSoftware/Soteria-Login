package com.artemissoftware.soterialogin.ui.register.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.artemissoftware.soterialogin.databinding.ItemSafetyQuestionAnswerBinding
import com.artemissoftware.soterialogin.ui.register.models.SafetyQuestion

class SafetyQuestionAnswerAdapter(): RecyclerView.Adapter<SafetyQuestionAnswerAdapter.SafetyQuestionAnswerViewHolder>() {

    val items: List<SafetyQuestion> = listOf()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SafetyQuestionAnswerViewHolder {
        val bind = ItemSafetyQuestionAnswerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SafetyQuestionAnswerViewHolder(bind)
    }

    override fun onBindViewHolder(holder: SafetyQuestionAnswerViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class SafetyQuestionAnswerViewHolder(private val binding: ItemSafetyQuestionAnswerBinding) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.imgAnswer.setOnClickListener {

                val position = adapterPosition

                if(position != RecyclerView.NO_POSITION){
                    //listener.onItemClick(getItem(position))
                }
            }
        }


        fun bind(model: SafetyQuestion) {
            with(binding) {
                item = model
                executePendingBindings()
            }
        }
    }


}