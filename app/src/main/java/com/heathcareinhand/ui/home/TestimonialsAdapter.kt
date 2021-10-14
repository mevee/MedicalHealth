package com.heathcareinhand.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.heathcareinhand.databinding.*
import com.heathcareinhand.ui.intro.IntroModel

class TestimonialsAdapter(val context: Context?, val introDataList: List<OfferingModel>) :
    RecyclerView.Adapter<TestimonialsAdapter.IntroViewHolder>() {

    data class IntroViewHolder(val bind: TestimonialItemBinding) : RecyclerView.ViewHolder(bind.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IntroViewHolder {
        val binding = TestimonialItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return IntroViewHolder(binding)
    }

    override fun onBindViewHolder(holder: IntroViewHolder, position: Int) {
        val bind = holder.bind
        val data = introDataList[position]
        bind.ivOffer.load(data.image){
            CircleCropTransformation()
        }
//        bind.tvOfferLine1.text = (data.title)
     }

    override fun getItemCount() = introDataList.size

}