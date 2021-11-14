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


class SafetyQuestionAdapter(val items: List<SafetyQuestion>/*, private val listener: CustomListener?*/):
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


////    fun updateList(list: MutableList<String>) {
////        this.list = list
////    }
////
////    fun getList(): MutableList<String> = this.list.toMutableList()
//
////    override fun onTouch(v: View?, event: MotionEvent?): Boolean {
////        when (event?.action) {
////            MotionEvent.ACTION_DOWN -> {
////                val data = ClipData.newPlainText("", "")
////                val shadowBuilder = View.DragShadowBuilder(v)
////                v?.startDragAndDrop(data, shadowBuilder, v, 0)
////                return true
////            }
////        }
////        return false
////    }
////
////    val dragInstance: DragListener?
////        get() = if (listener != null) {
////            DragListener(listener)
////        } else {
////            Log.e(javaClass::class.simpleName, "Listener not initialized")
////            null
////        }
//
////    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
////        holder.text?.text = list[position]
////        holder.frameLayout?.tag = position
////        holder.frameLayout?.setOnTouchListener(this)
////        holder.frameLayout?.setOnDragListener(DragListener(listener!!))
////    }
//
////    class CustomViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
////        RecyclerView.ViewHolder(inflater.inflate(R.layout.list_item, parent, false)) {
////        var text: TextView? = null
////        var frameLayout: FrameLayout? = null
////
////        init {
////            text = itemView.findViewById(R.id.text)
////            frameLayout = itemView.findViewById(R.id.frame_layout_item)
////        }
////    }
//
    inner class SafetyQuestionViewHolder(private val binding: ItemSafetyQuestionBinding) : RecyclerView.ViewHolder(binding.root) {
//
//        init {
////            binding.root.setOnClickListener {
////
////                val position = adapterPosition
////
////                if(position != RecyclerView.NO_POSITION){
////                    listener.onItemClick(getItem(position))
////                }
////            }
//        }

        fun bind(model: SafetyQuestion, touchListener: View.OnTouchListener) {
            with(binding) {

                root.setOnTouchListener(touchListener)

                item = model
////                glide.load(model.imageUrl)
////                    .transition(DrawableTransitionOptions.withCrossFade(500))
////                    .into(binding.imgDog)
                executePendingBindings()
            }
        }

    }




}