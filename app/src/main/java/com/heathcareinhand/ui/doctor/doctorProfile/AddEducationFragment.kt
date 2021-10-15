package com.heathcareinhand.ui.doctor.doctorProfile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.heathcareinhand.R
import com.heathcareinhand.databinding.FragmentAddEducationBinding

// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AddEducationFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddEducationFragment : BottomSheetDialogFragment() {
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding: FragmentAddEducationBinding

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
        binding = FragmentAddEducationBinding.inflate(inflater, container, false)
        isCancelable = false
        binding.ivCloseFilter.setOnClickListener { dismiss() }
        binding.tvSubmit.setOnClickListener { dismiss() }

        val degreeAdapter = ArrayAdapter(
            requireContext(), R.layout.support_simple_spinner_dropdown_item, listOf(
                "Mbbs",
                "Mphil",
                "MBBC",
                "Mbbs",
                "Mphil",
                "MBBC",
            )
        )
        val adapter = ArrayAdapter(
            requireContext(), R.layout.support_simple_spinner_dropdown_item, listOf(
                "India",
                "Usa",
                "Canada",
                "Nepal",
                "Bagladesh",
            )
        )
        binding.spCountry.adapter = adapter
        binding.spDegree.adapter = degreeAdapter
        return binding.root
    }


    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AddEducationFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}