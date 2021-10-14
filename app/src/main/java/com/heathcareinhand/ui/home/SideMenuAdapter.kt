package com.heathcareinhand.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.heathcareinhand.databinding.IntroItemBinding
import com.heathcareinhand.databinding.SideMenuItemBinding

class SideMenuAdapter(val context: Context?, val introDataList: List<SideMenuModel>, val listner:(position:Int,action:String)->Unit) :
    RecyclerView.Adapter<SideMenuAdapter.IntroViewHolder>() {

    data class IntroViewHolder(val bind: SideMenuItemBinding) : RecyclerView.ViewHolder(bind.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IntroViewHolder {
        val binding = SideMenuItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return IntroViewHolder(binding)
    }

    override fun onBindViewHolder(holder: IntroViewHolder, position: Int) {
        val bind = holder.bind
        val data = introDataList[position]
        bind.ivSideMenu.load(data.image)
        bind.tvSideMenu.text = "${data.title}"
        bind.mainSideMenu.setOnClickListener {
            listner.invoke(position,data.id)
        }

    }

    override fun getItemCount() = introDataList.size

}