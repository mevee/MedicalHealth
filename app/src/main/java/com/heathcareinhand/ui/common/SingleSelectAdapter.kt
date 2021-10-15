package com.heathcareinhand.ui.common

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.heathcareinhand.R
import com.heathcareinhand.databinding.*
import com.heathcareinhand.ui.intro.IntroModel

class SingleSelectAdapter(
    val context: Context?,
    val introDataList: List<SelectModel>,
    val listener:(position:Int,selectedValue:String)->Unit
) :
    RecyclerView.Adapter<SingleSelectAdapter.IntroViewHolder>() {
    var selectIndex = -1

     fun setSelection(position: Int){
        if (position>introDataList.size)
            return
        selectIndex =position
        notifyDataSetChanged()
    }
    data class IntroViewHolder(val bind: SingleSelectItemBinding) :
        RecyclerView.ViewHolder(bind.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IntroViewHolder {
        val binding = SingleSelectItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return IntroViewHolder(binding)
    }

    override fun onBindViewHolder(holder: IntroViewHolder, position: Int) {
        val bind = holder.bind
        val data = introDataList[position]
        if (selectIndex == position) {
            val color = context?.resources?.getColor(R.color.white)
            val bg = context?.resources?.getDrawable(R.drawable.btn_8)
            color?.let { bind.tvSelectable.setTextColor(it) }
            bg?.let { bind.tvSelectable.setBackgroundDrawable(bg) }

        } else {
            val color = context?.resources?.getColor(R.color.txtBlack1)
            color?.let { bind.tvSelectable.setTextColor(it) }
            val bg = context?.resources?.getDrawable(R.drawable.stroke_8)
            bg?.let { bind.tvSelectable.setBackgroundDrawable(bg) }
        }

        bind.tvSelectable.text = data.title
        bind.tvSelectable.setOnClickListener {
            if (selectIndex != position) {
                    listener.invoke(position,data.title)
                    selectIndex = position
                    notifyDataSetChanged()
            }
        }
//        bind.cardDoctor.setOnClickListener { listener.invoke(position, true) }
//        bind.tvBookAppointment.setOnClickListener { listener.invoke(position, true) }
    }

    override fun getItemCount() = introDataList.size

}