package com.heathcareinhand.ui.doctor.filter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.heathcareinhand.R
import com.heathcareinhand.databinding.FragmentFilterDoctorBinding
import com.heathcareinhand.databinding.MultiSelectItemBinding
import com.heathcareinhand.ui.common.MultiSelectAdapter
import com.heathcareinhand.ui.common.SelectModel
import com.heathcareinhand.ui.doctor.DoctorSchedule
import com.heathcareinhand.ui.doctor.DoctorTimeTableAdapter

// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class FilterDoctorFragment : DialogFragment() {
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var binding: FragmentFilterDoctorBinding
    private lateinit var specielistAdapter: MultiSelectAdapter
    private lateinit var availableAdapter: MultiSelectAdapter
    private lateinit var feeRangeAdapter: MultiSelectAdapter
    private lateinit var experienceAdapter: MultiSelectAdapter
    private lateinit var genderAdapter: MultiSelectAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFilterDoctorBinding.inflate(layoutInflater, container, false)

        binding.ivCloseFilter.setOnClickListener { dismiss() }
        binding.tvApplyFilter.setOnClickListener { dismiss() }
        binding.tvReset.setOnClickListener { dismiss() }

        setGender()
        setSpecielist()
        setAvailabelOn()
        setExperience()
        setFeeRanges()
        return binding.root
    }

    private fun setSpecielist() {
        val calenderList = listOf(
            SelectModel(
                "Allergist",
                1
            ),
            SelectModel(
                "Cardiologist",
                3
            ),
            SelectModel(
                "Technologiest",
                2
            ),
            SelectModel(
                "Dermologist",
                2
            ),
            SelectModel(
                "Dietian",
                2
            ),
            SelectModel(
                "Cardiologist",
                3
            ),
            SelectModel(
                "Technologiest",
                2
            ),
            SelectModel(
                "Dermologist",
                2
            ),
            SelectModel(
                "Dietian",
                2
            ),
        )
        specielistAdapter = MultiSelectAdapter(context, calenderList) { position, selectedValue -> }
        binding.rvSpecialist.adapter = specielistAdapter
        binding.rvSpecialist.layoutManager = StaggeredGridLayoutManager(3, LinearLayoutManager.VERTICAL)

    }

    private fun setAvailabelOn() {
        val calenderList = listOf(
            SelectModel(
                "Call",
                1
            ),
            SelectModel(
                "Video",
                3
            ),
            SelectModel(
                "Message",
                2
            ),
            SelectModel(
                "In Clinic",
                2
            ),
        )
        availableAdapter = MultiSelectAdapter(context, calenderList) { position, selectedValue -> }
        binding.rvAvailableOn.adapter = availableAdapter
        binding.rvAvailableOn.layoutManager = StaggeredGridLayoutManager(3, LinearLayoutManager.VERTICAL)

    }

    private fun setFeeRanges() {
        val calenderList = listOf(
            SelectModel(
                "100-400",
                1
            ),
            SelectModel(
                "400-700",
                3
            ),
            SelectModel(
                "700-1000",
                2
            ),
            SelectModel(
                "1000+",
                4
            ),
        )
        feeRangeAdapter = MultiSelectAdapter(context, calenderList) { position, selectedValue -> }
        binding.rvFeeRange.adapter = feeRangeAdapter
        binding.rvFeeRange.layoutManager = StaggeredGridLayoutManager(3, LinearLayoutManager.VERTICAL)

    }

    private fun setExperience() {
        val calenderList = listOf(
            SelectModel(
                "1-5",
                1
            ),
            SelectModel(
                "5-10",
                3
            ),
            SelectModel(
                "10-15",
                2
            ),
            SelectModel(
                "15-20",
                1
            ),
            SelectModel(
                "20-25",
                3
            ),
            SelectModel(
                "25-30",
                2
            ),
        )
        experienceAdapter = MultiSelectAdapter(context, calenderList) { position, selectedValue -> }
        binding.rvExperience.adapter = experienceAdapter
        binding.rvExperience.layoutManager = StaggeredGridLayoutManager(3, LinearLayoutManager.VERTICAL)

    }

    private fun setGender() {
        val calenderList = listOf(
            SelectModel(
                "Male",
                1
            ),
            SelectModel(
                "Female",
                3
            ),
            SelectModel(
                "Other",
                2
            ),
        )
        genderAdapter = MultiSelectAdapter(context, calenderList) { position, selectedValue -> }
        binding.rvGender.adapter = genderAdapter
        binding.rvGender.layoutManager = StaggeredGridLayoutManager(3, LinearLayoutManager.VERTICAL)

    }

    override fun onStart() {
        super.onStart()
        // safety check
        if (dialog == null) {
            return
        }
        // set the animations to use on showing and hiding the dialog
        dialog!!.window!!.setWindowAnimations(
            R.style.dialog_animation_fade
        )
    }

    override fun getTheme(): Int {
        return R.style.DialogTheme
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FilterDoctorFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}