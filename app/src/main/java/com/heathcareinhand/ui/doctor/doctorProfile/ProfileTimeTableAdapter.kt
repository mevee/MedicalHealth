package com.heathcareinhand.ui.doctor.doctorProfile

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.heathcareinhand.databinding.*
import com.heathcareinhand.ui.common.SelectModel
import com.heathcareinhand.ui.common.SingleListAdapter
import com.heathcareinhand.ui.common.SingleSelectAdapter
import com.heathcareinhand.ui.doctor.DoctorSchedule
import com.heathcareinhand.ui.intro.IntroModel

class ProfileTimeTableAdapter(
    val context: Context?,
    val introDataList: List<DoctorSchedule>,
    val listener:(position:Int,selectedValue:String)->Unit
) :
    RecyclerView.Adapter<ProfileTimeTableAdapter.IntroViewHolder>() {

    var selectPosition=-1
    var innerPosition=-1

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

        val dataList: MutableList<SelectModel> = mutableListOf()

        for (index in data.timeSlots.indices) {
            val timeSlot = data.timeSlots[index]
            dataList.add(SelectModel(timeSlot, index))
        }

        val timeSelectAdapter = SingleListAdapter(context, dataList){
            positionLocal, selectedValue ->
            if (selectPosition!=position){
                this.selectPosition = position
                this.innerPosition = positionLocal
                listener.invoke(position,"${data.date} at $selectedValue")
//                timeSelectAdapter.setSelection()
//                setSelection(timeSelectAdapter,this)
            }
        }
        bind.rvTimeSlots.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        bind.rvTimeSlots.adapter = timeSelectAdapter
    }


    override fun getItemCount() = introDataList.size

}