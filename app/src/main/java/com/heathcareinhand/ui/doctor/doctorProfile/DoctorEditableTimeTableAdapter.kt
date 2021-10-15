package com.heathcareinhand.ui.doctor.doctorProfile

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.heathcareinhand.R
import com.heathcareinhand.databinding.*
import com.heathcareinhand.ui.common.SelectModel
import com.heathcareinhand.ui.common.SingleListAdapter
import com.heathcareinhand.ui.common.SingleSelectAdapter
import com.heathcareinhand.ui.doctor.DoctorSchedule
import com.heathcareinhand.ui.intro.IntroModel

class DoctorEditableTimeTableAdapter(
    val context: Context?,
    val introDataList: List<DoctorScheduleEditable>,
    val listener:(position:Int,selectedValue:String)->Unit
) :
    RecyclerView.Adapter<DoctorEditableTimeTableAdapter.IntroViewHolder>() {

    var selectPosition=-1
    var innerPosition=-1

    var selectIndex = -1

    fun setSelection(position: Int){
        if (position>introDataList.size)
            return
        selectIndex =position
        notifyDataSetChanged()
    }

    data class IntroViewHolder(val bind: ScheduleEditableItemBinding) : RecyclerView.ViewHolder(bind.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IntroViewHolder {
        val binding = ScheduleEditableItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return IntroViewHolder(binding)
    }

    override fun onBindViewHolder(holder: IntroViewHolder, position: Int) {
        val bind = holder.bind
        val data = introDataList[position]

         bind.tvDayName.text = (data.day)
        if (selectIndex == position) {
            val color = context?.resources?.getColor(R.color.white)
            val bg = context?.resources?.getDrawable(R.drawable.btn_8)
            color?.let { bind.tvDayName.setTextColor(it) }
            bg?.let { bind.tvDayName.setBackgroundDrawable(bg) }

        } else {
            val color = context?.resources?.getColor(R.color.txtBlack1)
            val bg = context?.resources?.getDrawable(R.drawable.stroke_8)
            color?.let { bind.tvDayName.setTextColor(it) }
            bg?.let { bind.tvDayName.setBackgroundDrawable(bg) }
        }

        val dataList: MutableList<SelectModel> = mutableListOf()

        for (index in data.timeSlots.indices) {
            val timeSlot = data.timeSlots[index]
            dataList.add(SelectModel(timeSlot, index))
        }
        bind.tvDayName.setOnClickListener {
            if (selectIndex != position) {
                selectIndex = position
                listener.invoke(position,data.day)
                notifyDataSetChanged()
            }
        }

        val timeSelectAdapter = SingleListAdapter(context, dataList){
            positionLocal, selectedValue ->
            if (selectPosition!=position){
                this.selectPosition = position
                this.innerPosition = positionLocal
//                listener.invoke(position,"${data.date} at $selectedValue")
           }
        }

        bind.rvTimeSlots.isNestedScrollingEnabled =false
        bind.rvTimeSlots.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        bind.rvTimeSlots.adapter = timeSelectAdapter
    }


    override fun getItemCount() = introDataList.size

}