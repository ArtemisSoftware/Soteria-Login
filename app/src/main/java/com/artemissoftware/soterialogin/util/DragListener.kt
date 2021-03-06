package com.artemissoftware.soterialogin.util

import android.view.DragEvent
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.artemissoftware.soterialogin.R
import com.artemissoftware.soterialogin.ui.register.adapters.DragDropListener
import com.artemissoftware.soterialogin.ui.register.adapters.SafetyQuestionAdapter
import com.artemissoftware.soterialogin.ui.register.adapters.SafetyQuestionAnswerAdapter
import com.artemissoftware.soterialogin.ui.register.models.SafetyQuestion

class DragListener internal constructor(private val listener: DragDropListener) : View.OnDragListener {

    private var isDropped = false

    override fun onDrag(v: View, event: DragEvent): Boolean {

        when (event.action) {
            DragEvent.ACTION_DROP -> {

                isDropped = true
                var positionTarget = -1
                val viewSource = event.localState as View?
                val viewId = v.id

                val frameLayoutItem = R.id.contraint_safety_question
                val recyclerView1 = R.id.rcl_questions
                val recyclerView2 = R.id.rcl_answers
                val frameLayoutItem2 = R.id.contraint_safety_question_answer
                val emptyTextView2 = R.id.empty_list_text_view_2

                /*
                val frameLayoutItem = R.id.frame_layout_item
                val emptyTextView1 = R.id.empty_list_text_view_1
                val emptyTextView2 = R.id.empty_list_text_view_2
                val recyclerView1 = R.id.recycler_view_1
                val recyclerView2 = R.id.recycler_view_2
                */

                when (viewId) {

                    frameLayoutItem,emptyTextView2, frameLayoutItem2, recyclerView1, recyclerView2 -> {

                        val target: RecyclerView

                        when (viewId) {
                            frameLayoutItem,recyclerView1 -> {
                                target = v.rootView.findViewById<View>(recyclerView1) as RecyclerView
                            }
                            frameLayoutItem2,recyclerView2, emptyTextView2 -> {
                                target = v.rootView.findViewById<View>(recyclerView2) as RecyclerView
                            }
                            else -> {
                                target = v.parent as RecyclerView
                                positionTarget = v.tag as Int
                            }
                        }


                        if (viewSource != null) {

                            //if its the same list dont add

                            if(viewSource.id == viewId){
                                return true
                            }


                            //remove from one list

                            val source = viewSource.parent as RecyclerView
                            val adapterSource = source.adapter as SafetyQuestionAdapter?
                            val positionSource = viewSource.tag as Int

                            val list: SafetyQuestion? = adapterSource?.getList()?.get(positionSource)
                            val listSource = adapterSource?.getList()?.apply {
                                removeAt(positionSource)
                            }
                            listSource?.let { adapterSource.updateList(it) }
                            adapterSource?.notifyDataSetChanged()

                            //add to the other


                            val adapterTarget = target.adapter as SafetyQuestionAnswerAdapter?
                            val customListTarget = adapterTarget?.getList()
                            if (positionTarget >= 0) {
                                list?.let { customListTarget?.add(positionTarget, it) }
                            } else {
                                list?.let { customListTarget?.add(it) }
                            }
                            customListTarget?.let { adapterTarget.updateList(it) }
                            adapterTarget?.notifyDataSetChanged()


                            if (source.id == recyclerView2 && adapterSource?.itemCount ?: 0 < 1) {
                                //listener.setEmptyList(View.VISIBLE, recyclerView2, emptyTextView2)
                            }


                            if (viewId == emptyTextView2) {
                                listener.setEmptyList(View.GONE)
                            }
                        }


                    }




                    /*
                    frameLayoutItem, emptyTextView1, emptyTextView2, recyclerView1, recyclerView2 -> {


                        val target: RecyclerView

                        when (viewId) {
                            emptyTextView1, recyclerView1 -> target = v.rootView.findViewById<View>(recyclerView1) as RecyclerView
                            emptyTextView2, recyclerView2 -> target = v.rootView.findViewById<View>(recyclerView2) as RecyclerView
                            else -> {
                                target = v.parent as RecyclerView
                                positionTarget = v.tag as Int
                            }
                        }

                        if (viewSource != null) {

                            val source = viewSource.parent as RecyclerView
                            val adapterSource = source.adapter as CustomAdapter?
                            val positionSource = viewSource.tag as Int
                            val list: String? = adapterSource?.getList()?.get(positionSource)
                            val listSource = adapterSource?.getList()?.apply {
                                removeAt(positionSource)
                            }

                            listSource?.let { adapterSource.updateList(it) }
                            adapterSource?.notifyDataSetChanged()
                            val adapterTarget = target.adapter as CustomAdapter?
                            val customListTarget = adapterTarget?.getList()
                            if (positionTarget >= 0) {
                                list?.let { customListTarget?.add(positionTarget, it) }
                            } else {
                                list?.let { customListTarget?.add(it) }
                            }
                            customListTarget?.let { adapterTarget.updateList(it) }
                            adapterTarget?.notifyDataSetChanged()


                            if (source.id == recyclerView2 && adapterSource?.itemCount ?: 0 < 1) {
                                listener.setEmptyList(View.VISIBLE, recyclerView2, emptyTextView2)
                            }
                            if (viewId == emptyTextView2) {
                                listener.setEmptyList(View.GONE, recyclerView2, emptyTextView2)
                            }
                            if (source.id == recyclerView1 && adapterSource?.itemCount ?: 0 < 1) {
                                listener.setEmptyList(View.VISIBLE, recyclerView1, emptyTextView1)
                            }
                            if (viewId == emptyTextView1) {
                                listener.setEmptyList(View.GONE, recyclerView1, emptyTextView1)
                            }
                        }


                    }
                    */

                }
            }
        }

        if (!isDropped && event.localState != null) {
            (event.localState as View).visibility = View.VISIBLE
        }

        return true
    }
}