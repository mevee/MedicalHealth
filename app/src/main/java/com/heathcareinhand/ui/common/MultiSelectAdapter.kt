package com.heathcareinhand.ui.common

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.CompoundButton
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.heathcareinhand.databinding.*
import com.heathcareinhand.ui.intro.IntroModel

class MultiSelectAdapter(
    val context: Context?,
    val introDataList: List<SelectModel>,
    val listener: (position: Int, action: Int) -> Unit
) :
    RecyclerView.Adapter<MultiSelectAdapter.IntroViewHolder>() {

    data class IntroViewHolder(val bind: MultiSelectItemBinding) :
        RecyclerView.ViewHolder(bind.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IntroViewHolder {
        val binding = MultiSelectItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return IntroViewHolder(binding)
    }

    override fun onBindViewHolder(holder: IntroViewHolder, position: Int) {
        val bind = holder.bind
        val data = introDataList[position]

        bind.cbSelectable.text = data.title
        bind.cbSelectable.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked)
                listener.invoke(position, 400)
            else
                listener.invoke(position, 500)
        }
    }

    override fun getItemCount() = introDataList.size

}