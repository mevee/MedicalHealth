package com.heathcareinhand.ui.doctor.doctorProfile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.heathcareinhand.R
import com.heathcareinhand.databinding.FragmentAddTimeBinding

// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class AddTimeFragment : BottomSheetDialogFragment() {
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var binding: FragmentAddTimeBinding
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
        isCancelable = false
        // Inflate the layout for this fragment
        binding = FragmentAddTimeBinding.inflate(inflater, container, false)
        binding.ivCloseFilter.setOnClickListener { dismiss() }
        binding.tvSubmit.setOnClickListener { dismiss() }

        val dayList = listOf(
            "Monday",
            "Tues",
            "Wed",
            "Thus",
            "Fri",
            "SAT",
            "SUN",
        )
        val adapter = ArrayAdapter(
            requireContext(), R.layout.support_simple_spinner_dropdown_item,   dayList

        )
        binding.spSelectDay.adapter = adapter

        for (index in dayList.indices) {
            val day = dayList[index]
            if (param1!=null&&day.toLowerCase().contains(param1!!.toLowerCase())){
                binding.spSelectDay.setSelection(index)
            }
        }
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AddTimeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}