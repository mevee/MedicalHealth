package com.heathcareinhand.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.heathcareinhand.databinding.IntroItemBinding
import com.heathcareinhand.databinding.OfferingItemBinding
import com.heathcareinhand.databinding.SliderItemBinding
import com.heathcareinhand.ui.intro.IntroModel

class OfferingsAdapter(val context: Context?, val introDataList: List<OfferingModel>,val listener:(position:Int,isClicked:Boolean)->Unit) :
    RecyclerView.Adapter<OfferingsAdapter.IntroViewHolder>() {

    data class IntroViewHolder(val bind: OfferingItemBinding) : RecyclerView.ViewHolder(bind.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IntroViewHolder {
        val binding = OfferingItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return IntroViewHolder(binding)
    }

    override fun onBindViewHolder(holder: IntroViewHolder, position: Int) {
        val bind = holder.bind
        val data = introDataList[position]
        bind.ivOffer.load(data.image)
        bind.tvOfferLine1.text = (data.title)
        bind.tvOfferLine2.text = (data.title2+ " "+data.title)
        bind.cardOffering.setOnClickListener { listener.invoke(position,true) }
        }

    override fun getItemCount() = introDataList.size

}