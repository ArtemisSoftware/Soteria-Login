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

class SafetyQuestionAnswerAdapter( var items: List<SafetyQuestion> = listOf(SafetyQuestion("", "", false, icon = -1))): RecyclerView.Adapter<SafetyQuestionAnswerAdapter.SafetyQuestionAnswerViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SafetyQuestionAnswerViewHolder {

        val bind = ItemSafetyQuestionAnswerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SafetyQuestionAnswerViewHolder(bind)
    }

    override fun onBindViewHolder(holder: SafetyQuestionAnswerViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemViewType(position: Int): Int {

        if(items[position].icon == -1){
            return 0
        }
        else return 1
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun getList(): MutableList<SafetyQuestion> = this.items.toMutableList()

    fun updateList(list: MutableList<SafetyQuestion>) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            list.removeIf { item -> item.icon == -1 }
        }

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

                root.setOnDragListener(DragListener(/*listener!!*/))

                if(items[adapterPosition].icon != -1){
                    txtNoAnswer.visibility = View.GONE
                }

                item = model
                executePendingBindings()
            }
        }
    }


}