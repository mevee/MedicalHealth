package com.heathcareinhand.ui.doctor.doctorProfile

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.heathcareinhand.databinding.ExperienceItemBinding
import com.heathcareinhand.databinding.IntroItemBinding
import com.heathcareinhand.databinding.OfferingItemBinding
import com.heathcareinhand.databinding.SliderItemBinding
import com.heathcareinhand.ui.home.OfferingModel
import com.heathcareinhand.ui.intro.IntroModel

class ExperienceAdapter(
    val context: Context?,
    val introDataList: MutableList<OfferingModel>,
    val listener: (position: Int, isClicked: Boolean) -> Unit
) :
    RecyclerView.Adapter<ExperienceAdapter.IntroViewHolder>() {

    data class IntroViewHolder(val bind: ExperienceItemBinding) : RecyclerView.ViewHolder(bind.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IntroViewHolder {
        val binding = ExperienceItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return IntroViewHolder(binding)
    }

    override fun onBindViewHolder(holder: IntroViewHolder, position: Int) {
        val bind = holder.bind
        val data = introDataList[position]
//        bind.ivOffer.load(data.image)
//        bind.tvOfferLine1.text = (data.title)
//        bind.tvOfferLine2.text = (data.title2 + " " + data.title)
//        bind.cardOffering.setOnClickListener { listener.invoke(position, true) }
        bind.ivDeleteExperience.setOnClickListener {
            introDataList.removeAt(position)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount() = introDataList.size

}