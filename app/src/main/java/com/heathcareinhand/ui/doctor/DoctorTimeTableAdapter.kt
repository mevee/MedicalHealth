package com.heathcareinhand.ui.doctor

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.heathcareinhand.databinding.*
import com.heathcareinhand.ui.intro.IntroModel

class DoctorTimeTableAdapter(
    val context: Context?,
    val introDataList: List<DoctorSchedule>,
) :
    RecyclerView.Adapter<DoctorTimeTableAdapter.IntroViewHolder>() {

    data class IntroViewHolder(val bind: ScheduleItemBinding) : RecyclerView.ViewHolder(bind.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IntroViewHolder {
        val binding = ScheduleItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return IntroViewHolder(binding)
    }

    override fun onBindViewHolder(holder: IntroViewHolder, position: Int) {
        val bind = holder.bind
        val data = introDataList[position]

        bind.tvDate.text = (data.date)
        bind.tvDayName.text = (data.day)

//        bind.cardDoctor.setOnClickListener { listener.invoke(position, true) }
//        bind.tvBookAppointment.setOnClickListener { listener.invoke(position, true) }
    }

    override fun getItemCount() = introDataList.size

}