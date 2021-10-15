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

class SingleListAdapter(
    val context: Context?,
    val introDataList: MutableList<SelectModel>,
    val listener:(position:Int,selectedValue:String)->Unit
) :
    RecyclerView.Adapter<SingleListAdapter.IntroViewHolder>() {

    data class IntroViewHolder(val bind: SingleEditableItemBinding) :
        RecyclerView.ViewHolder(bind.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IntroViewHolder {
        val binding = SingleEditableItemBinding.inflate(LayoutInflater.from(context), parent, false)
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