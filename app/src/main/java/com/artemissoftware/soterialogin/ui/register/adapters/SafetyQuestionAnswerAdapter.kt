package com.artemissoftware.soterialogin.ui.register.adapters

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.artemissoftware.soterialogin.databinding.ItemSafetyQuestionAnswerBinding
import com.artemissoftware.soterialogin.databinding.ItemSafetyQuestionNoAnswerBinding
import com.artemissoftware.soterialogin.ui.register.models.SafetyQuestion
import com.artemissoftware.soterialogin.util.DragListener
import com.bumptech.glide.Glide

class SafetyQuestionAnswerAdapter(private val listener: DragDropListener, private var items: List<SafetyQuestion> = listOf()): RecyclerView.Adapter<SafetyQuestionAnswerAdapter.SafetyQuestionAnswerViewHolder>() {



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

    fun getList(): MutableList<SafetyQuestion> = this.items.toMutableList()

    fun updateList(list: MutableList<SafetyQuestion>) {
        this.items = list
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

                root.setOnDragListener(DragListener(listener))

                Glide.with(root.context).load(model.icon).into(imgAnswer)

                item = model
                executePendingBindings()
            }
        }
    }


}