package com.artemissoftware.soterialogin.ui.register.adapters

import android.content.ClipData
import android.os.Build
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.artemissoftware.soterialogin.R
import com.artemissoftware.soterialogin.databinding.ItemSafetyQuestionBinding
import com.artemissoftware.soterialogin.ui.register.models.SafetyQuestion
import com.artemissoftware.soterialogin.util.DragListener
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager


class SafetyQuestionAdapter(private val listener: DragDropListener, var items: List<SafetyQuestion>):
    RecyclerView.Adapter<SafetyQuestionAdapter.SafetyQuestionViewHolder>(),
    View.OnTouchListener, View.OnLongClickListener {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SafetyQuestionViewHolder {
        val bind = ItemSafetyQuestionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SafetyQuestionViewHolder(bind)
    }

    override fun onBindViewHolder(holder: SafetyQuestionViewHolder, position: Int) {
        holder.bind(items[position], this, this)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onLongClick(v: View?): Boolean {

        val data = ClipData.newPlainText("", "")
        val shadowBuilder = View.DragShadowBuilder(v)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            v?.startDragAndDrop(data, shadowBuilder, v, 0)
        }
        return true
    }

    override fun onTouch(v: View?, event: MotionEvent?): Boolean {

        when (event?.action) {
            MotionEvent.ACTION_DOWN -> {

                val data = ClipData.newPlainText("", "")
                val shadowBuilder = View.DragShadowBuilder(v)

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    v?.startDragAndDrop(data, shadowBuilder, v, 0)
                }

                return true
            }
        }
        return false
    }

    fun getList(): MutableList<SafetyQuestion> = this.items.toMutableList()

    fun updateList(list: MutableList<SafetyQuestion>) {
        this.items = list
    }


    inner class SafetyQuestionViewHolder(private val binding: ItemSafetyQuestionBinding) : RecyclerView.ViewHolder(binding.root) {


        fun bind(model: SafetyQuestion, touchListener: View.OnTouchListener, longListener: View.OnLongClickListener) {
            with(binding) {

                root.setOnLongClickListener(longListener)
                //root.setOnTouchListener(touchListener)
                root.setOnDragListener(DragListener(listener))
                root.tag = adapterPosition

                item = model

                Glide.with(root.context).load(model.icon).into(imgQuestion)

                executePendingBindings()
            }
        }

    }




}