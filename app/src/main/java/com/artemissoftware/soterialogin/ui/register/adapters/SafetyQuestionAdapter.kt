package com.artemissoftware.soterialogin.ui.register.adapters

import android.content.ClipData
import android.os.Build
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.artemissoftware.soterialogin.databinding.ItemSafetyQuestionBinding
import com.artemissoftware.soterialogin.ui.register.models.SafetyQuestion
import com.artemissoftware.soterialogin.util.DragListener


class SafetyQuestionAdapter(var items: List<SafetyQuestion>/*, private val listener: CustomListener?*/):
    RecyclerView.Adapter<SafetyQuestionAdapter.SafetyQuestionViewHolder>(),
    View.OnTouchListener {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SafetyQuestionViewHolder {
        val bind = ItemSafetyQuestionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SafetyQuestionViewHolder(bind)
    }

    override fun onBindViewHolder(holder: SafetyQuestionViewHolder, position: Int) {
        holder.bind(items[position], this)
    }

    override fun getItemCount(): Int {
        return items.size
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


////    val dragInstance: DragListener?
////        get() = if (listener != null) {
////            DragListener(listener)
////        } else {
////            Log.e(javaClass::class.simpleName, "Listener not initialized")
////            null
////        }

    inner class SafetyQuestionViewHolder(private val binding: ItemSafetyQuestionBinding) : RecyclerView.ViewHolder(binding.root) {


        fun bind(model: SafetyQuestion, touchListener: View.OnTouchListener) {
            with(binding) {

                root.setOnTouchListener(touchListener)
                root.setOnDragListener(DragListener(/*listener!!*/))
                root.tag = adapterPosition

                item = model
////                glide.load(model.imageUrl)
////                    .transition(DrawableTransitionOptions.withCrossFade(500))
////                    .into(binding.imgDog)
                executePendingBindings()
            }
        }

    }




}