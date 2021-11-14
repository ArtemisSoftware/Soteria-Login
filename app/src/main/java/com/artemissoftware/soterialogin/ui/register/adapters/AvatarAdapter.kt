package com.artemissoftware.soterialogin.ui.register.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.artemissoftware.soterialogin.ui.register.models.Avatar
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.widget.ArrayAdapter
import android.widget.ImageView
import com.artemissoftware.soterialogin.R
import com.artemissoftware.soterialogin.databinding.ItemAvatarBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions


class AvatarAdapter internal constructor(context: Context, private val resource: Int, private val itemList: List<Avatar>) : ArrayAdapter<AvatarAdapter.ItemHolder>(context, resource) {

    override fun getCount(): Int {
        return if (this.itemList != null) this.itemList.size else 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val bind = ItemAvatarBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        with(bind) {

            imgIcon.setOnClickListener {
                update(position)
            }

            val item = itemList[position]
            Glide.with(root.context).load(item.icon).into(imgIcon)

            if(item.selected){
                val colorInt = root.context.resources.getColor(R.color.purple_700)
                val csl = ColorStateList.valueOf(colorInt)

                imgIcon.strokeColor =csl
            }

        }

        return bind.root
    }

    override fun hasStableIds(): Boolean {
        return true
    }

    fun update(position: Int) {

        itemList.forEachIndexed { index, avatar ->
            if(position == index){
                avatar.selected = !avatar.selected
            }
            else{
                avatar.selected = false
            }
        }

        notifyDataSetChanged()
    }

    class ItemHolder {
        var icon: ImageView? = null
    }
}

