package com.heathcareinhand.ui.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.databinding.DataBindingUtil
import com.heathcareinhand.R
import com.heathcareinhand.databinding.ActivityLoginBinding
import com.heathcareinhand.ui.signup.RegisterAsActivity

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        binding.backLogin.setOnClickListener { onBackPressed() }
//        binding.btnContinue.alpha = 0.3f
//        binding.btnContinue.isEnabled = false

        binding.etMobileNumber.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                if (s.toString().length <= 0) {
                    binding.btnContinue.alpha = 0.3f

                    binding.btnContinue.isEnabled = false
                } else {
                    binding.btnContinue.isEnabled = true
                    binding.btnContinue.alpha = 1f

                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun afterTextChanged(s: Editable?) {


            }
        })
        binding.btnContinue.setOnClickListener {
            otpScreen()
        }
        binding.tbSignUp.setOnClickListener {
            registerScreen()
        }

    }

    fun registerScreen() {
        startActivity(Intent(this, SignupDoctorActivity::class.java))
//        startActivity(Intent(this, RegisterAsActivity::class.java))
     }

    fun otpScreen() {
        startActivity(Intent(this, OtpActivity::class.java))
     }
}