package com.heathcareinhand.ui.intro

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.heathcareinhand.databinding.IntroItemBinding

class IntroAdapter(val context: Context?, val introDataList: List<IntroModel>) :
    RecyclerView.Adapter<IntroAdapter.IntroViewHolder>() {

    data class IntroViewHolder(val bind: IntroItemBinding) : RecyclerView.ViewHolder(bind.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IntroViewHolder {
        val binding = IntroItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return IntroViewHolder(binding)
    }

    override fun onBindViewHolder(holder: IntroViewHolder, position: Int) {
        val bind = holder.bind
        val data = introDataList[position]
        bind.ivIntro.load(data.image)
        bind.tvMessageIntro.text = "${data.title}"

    }

    override fun getItemCount() = introDataList.size

}