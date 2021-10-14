package com.heathcareinhand.ui.doctor

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.heathcareinhand.databinding.DoctorItemBinding
import com.heathcareinhand.databinding.IntroItemBinding
import com.heathcareinhand.databinding.OfferingItemBinding
import com.heathcareinhand.databinding.SliderItemBinding
import com.heathcareinhand.ui.intro.IntroModel

class DoctorListAdapter(
    val context: Context?,
    val introDataList: List<DoctorModel>,
    val listener: (position: Int, isClicked: Boolean,sharedView: View) -> Unit
) :
    RecyclerView.Adapter<DoctorListAdapter.IntroViewHolder>() {

    data class IntroViewHolder(val bind: DoctorItemBinding) : RecyclerView.ViewHolder(bind.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IntroViewHolder {
        val binding = DoctorItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return IntroViewHolder(binding)
    }

    override fun onBindViewHolder(holder: IntroViewHolder, position: Int) {
        val bind = holder.bind
        val data = introDataList[position]
        bind.ivDoctor.load(data.image) {
            crossfade(true)
            transformations(CircleCropTransformation())
        }

        bind.tvDoctorName.text = (data.name)
        bind.ratingBar.rating = data.rate
        bind.tvTotalRating.text = " ${data.totalRating}"
        bind.tvExpertise.text = "${data.expertise}"
        bind.tvPracticeExperinece.text = "Practice Experience: ${data.experience}"
        bind.tvChatRate.text = "Chat: Rs.${data.chatRate}"
        bind.tvAudioRate.text = "Call: Rs.${data.callAudioRate}"
        bind.tvVideoRate.text = "Call: Rs.${data.callVideoRate}"
        bind.cardDoctor.setOnClickListener { listener.invoke(position, true,bind.cardDoctor) }
        bind.tvBookAppointment.setOnClickListener { listener.invoke(position, true,bind.cardDoctor) }

    }

    override fun getItemCount() = introDataList.size

}