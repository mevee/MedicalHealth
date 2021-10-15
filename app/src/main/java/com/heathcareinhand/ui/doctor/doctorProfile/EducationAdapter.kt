package com.heathcareinhand.ui.doctor.doctorProfile

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.heathcareinhand.databinding.*
import com.heathcareinhand.ui.home.OfferingModel
import com.heathcareinhand.ui.intro.IntroModel

class EducationAdapter(
    val context: Context?,
    val introDataList: MutableList<OfferingModel>,
    val listener: (position: Int, isClicked: Boolean) -> Unit
) :
    RecyclerView.Adapter<EducationAdapter.IntroViewHolder>() {

    data class IntroViewHolder(val bind: EducationItemBinding) : RecyclerView.ViewHolder(bind.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IntroViewHolder {
        val binding = EducationItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return IntroViewHolder(binding)
    }

    override fun onBindViewHolder(holder: IntroViewHolder, position: Int) {
        val bind = holder.bind
        val data = introDataList[position]
        bind.ivDeleteExperience.setOnClickListener {
            introDataList.removeAt(position)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount() = introDataList.size

}