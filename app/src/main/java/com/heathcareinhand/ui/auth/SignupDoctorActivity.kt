package com.heathcareinhand.ui.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.heathcareinhand.R
import com.heathcareinhand.databinding.ActivitySignupDoctorBinding
import com.heathcareinhand.ui.HomeActivity
import com.heathcareinhand.ui.common.MultiSelectAdapter
import com.heathcareinhand.ui.common.SelectModel

class SignupDoctorActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignupDoctorBinding
    private lateinit var specielistAdapter:MultiSelectAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_signup_doctor)

        binding.backLogin.setOnClickListener { onBackPressed() }
        binding.btnContinue.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    OtpActivity::class.java
                )
            )
        }

        val experience = ArrayAdapter(
            this, R.layout.support_simple_spinner_dropdown_item, listOf(
                "--Select Experience--",
                "less the a year",
                "<2 year",
                "<4 year",
                "<6 year",
                "<8 year",
                "<10 year",
                "<12 year",
            )
        )
        val specielity = ArrayAdapter(
            this, R.layout.support_simple_spinner_dropdown_item, listOf(
                "Technologiest",
                "Dermologistr",
                "Cardiologist",
                "Dietian",
                "Dermologistr",
                "Cardiologist",
                "Dietian",
            )
        )
        binding.spExperience.adapter = experience
        binding.spExpert.adapter = specielity
        setSpecielist()
    }

    private fun setSpecielist() {
        val calenderList = listOf(
            SelectModel(
                "Intensive care",
                1
            ),
            SelectModel(
                "Critical care",
                3
            ),
            SelectModel(
                "Intensive care",
                1
            ),
            SelectModel(
                "Critical care",
                3
            ),
            SelectModel(
                "Intensive care",
                1
            ),
            SelectModel(
                "Critical care",
                3
            ),
        )

        binding.rvExpertise.isNestedScrollingEnabled = false
        specielistAdapter = MultiSelectAdapter(this, calenderList) { position, selectedValue -> }
        binding.rvExpertise.adapter = specielistAdapter
        binding.rvExpertise.layoutManager =
            StaggeredGridLayoutManager(3, LinearLayoutManager.VERTICAL)

    }

}