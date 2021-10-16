package com.heathcareinhand.ui.doctor.doctorProfile

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.heathcareinhand.databinding.*
import com.heathcareinhand.ui.common.SelectModel

class TiimeSlotEditableAdapter(
    val context: Context?,
    val introDataList: MutableList<SelectModel>,
    val listener:(position:Int,selectedValue:String)->Unit
) :
    RecyclerView.Adapter<TiimeSlotEditableAdapter.IntroViewHolder>() {

    data class IntroViewHolder(val bind: TimeSlotEditableItemBinding) :
        RecyclerView.ViewHolder(bind.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IntroViewHolder {
        val binding = TimeSlotEditableItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return IntroViewHolder(binding)
    }

    override fun onBindViewHolder(holder: IntroViewHolder, position: Int) {
        val bind = holder.bind
        val data = introDataList[position]

        bind.tvSelectable.text = data.title
        bind.ivRemove.setOnClickListener {
            introDataList.removeAt(position)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount() = introDataList.size

}