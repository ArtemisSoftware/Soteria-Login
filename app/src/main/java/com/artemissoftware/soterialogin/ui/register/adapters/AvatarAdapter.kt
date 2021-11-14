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
//        var convertView_ = convertView
//
//        val holder: ItemHolder
//        if (convertView == null) {
//            convertView_ = LayoutInflater.from(context).inflate(resource, null)
//            holder = ItemHolder()
//            holder.icon = convertView_.findViewById(R.id.img_icon)
//            convertView_.tag = holder
//            holder.icon!!.setImageResource(R.drawable.ic_question_1)
//            return convertView_
//        } else {
//            holder = convertView.tag as ItemHolder
//        }
//
//
//
//        return convertView

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
                //imgIcon.strokeColor = root.context.resources.getColor(R.color.purple_700)
                //imgIcon.borderColor = root.context.resources.getColor(R.color.purple_700)
            }
            else{
                //imgIcon.borderColor = root.context.resources.getColor(R.color.teal_200)
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

        //itemList[position].selected = true
        notifyDataSetChanged()
    }

    class ItemHolder {
        var icon: ImageView? = null
    }
}



//class AvatarAdapter(private val items: List<Avatar>) : BaseAdapter() {
//
//    override fun getView(position: Int, view: View?, viewGroup: ViewGroup): View {
////        val bind = ItemAvatarBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
////
////        with(bind) {
////
////            val item = items[position]
////            Glide.with(root.context).load(item.icon).into(imgIcon)
////
////        }
////        return bind.root
//
//        view = inflater.inflate(R.layout., null) // inflate the layout
//
//        val icon: ImageView =
//            view.findViewById(R.id.icon) as ImageView // get the reference of ImageView
//
//        icon.setImageResource(R.drawable.ic_menu_zoom) // set logo images
//
//        return view
//
//    }
//
//
//    override fun getCount(): Int {
//        return items.size
//    }
//
//    override fun getItem(position: Int): Avatar {
//        return items[position]
//    }
//
//    override fun getItemId(position: Int): Long {
//        return 0
//    }
//
//}