package com.heathcareinhand.ui.common

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.heathcareinhand.databinding.IntroItemBinding
import com.heathcareinhand.databinding.SliderItemBinding
import com.heathcareinhand.ui.intro.IntroModel

class SliderAdapter(val context: Context?, val introDataList: List<SliderModel>) :
    RecyclerView.Adapter<SliderAdapter.IntroViewHolder>() {

    data class IntroViewHolder(val bind: SliderItemBinding) : RecyclerView.ViewHolder(bind.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IntroViewHolder {
        val binding = SliderItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return IntroViewHolder(binding)
    }

    override fun onBindViewHolder(holder: IntroViewHolder, position: Int) {
        val bind = holder.bind
        val data = introDataList[position]
        bind.ivIntro.load(data.image)
    }

    override fun getItemCount() = introDataList.size

}