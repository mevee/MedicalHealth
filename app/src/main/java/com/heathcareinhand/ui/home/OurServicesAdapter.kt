package com.heathcareinhand.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.heathcareinhand.databinding.IntroItemBinding
import com.heathcareinhand.databinding.OfferingItemBinding
import com.heathcareinhand.databinding.OurServiceItemBinding
import com.heathcareinhand.databinding.SliderItemBinding
import com.heathcareinhand.ui.intro.IntroModel

class OurServicesAdapter(val context: Context?, val introDataList: List<OfferingModel>) :
    RecyclerView.Adapter<OurServicesAdapter.IntroViewHolder>() {

    data class IntroViewHolder(val bind: OurServiceItemBinding) : RecyclerView.ViewHolder(bind.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IntroViewHolder {
        val binding = OurServiceItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return IntroViewHolder(binding)
    }

    override fun onBindViewHolder(holder: IntroViewHolder, position: Int) {
        val bind = holder.bind
        val data = introDataList[position]
        bind.ivOffer.load(data.image)
        bind.tvOfferLine1.text = (data.title)
     }

    override fun getItemCount() = introDataList.size

}