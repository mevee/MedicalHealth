package com.heathcareinhand.ui.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import com.heathcareinhand.R
import com.heathcareinhand.databinding.ActivitySignupDoctorBinding
import com.heathcareinhand.ui.HomeActivity

class SignupDoctorActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignupDoctorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_signup_doctor)

        binding.backLogin.setOnClickListener { onBackPressed() }
        binding.btnContinue.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    HomeActivity::class.java
                )
            )
        }

        val adapter = ArrayAdapter(
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
        binding.spExperience.adapter = adapter
    }
}