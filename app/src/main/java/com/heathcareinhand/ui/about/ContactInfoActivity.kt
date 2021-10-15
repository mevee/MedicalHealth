package com.heathcareinhand.ui.about

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.heathcareinhand.R
import com.heathcareinhand.databinding.ActivityContactInfoBinding

class ContactInfoActivity : AppCompatActivity() {
    private lateinit var binding:ActivityContactInfoBinding
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_contact_info)
        binding.toolContactInfo.home.setOnClickListener { onBackPressed() }
        binding.toolContactInfo.toolBack.setOnClickListener { onBackPressed() }
        binding.toolContactInfo.toolTitle.text = "Contact Info"
    }
}