package com.heathcareinhand.ui.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.databinding.DataBindingUtil
import com.heathcareinhand.R
import com.heathcareinhand.databinding.ActivityOtpBinding
import com.heathcareinhand.ui.HomeActivity

class OtpActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOtpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_otp)
        binding.backLogin.setOnClickListener { onBackPressed() }
        binding.resendOTP.setOnClickListener {
            binding.resendOTP.alpha = 0.3f
            binding.resendOTP.isEnabled = false

            Handler().postDelayed({
                binding.btnContinueOtp.alpha = 0.3f
                binding.btnContinueOtp.isEnabled = false

                binding.otpTextView.otp = ""
                binding.resendOTP.alpha = 1f
                binding.resendOTP.isEnabled = true
            }, 2000)
        }

        binding.btnContinueOtp.setOnClickListener {
            launchHomeScreen()
        }
    }
    fun launchHomeScreen() {
        startActivity(Intent(this, HomeActivity::class.java))
        finish()
    }
}