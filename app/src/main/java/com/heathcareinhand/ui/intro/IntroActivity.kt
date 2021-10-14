package com.heathcareinhand.ui.intro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.databinding.DataBindingUtil
import com.heathcareinhand.R
import com.heathcareinhand.databinding.ActivityIntroBinding
import com.heathcareinhand.databinding.IntroItemBinding
import com.heathcareinhand.ui.HomeActivity
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import androidx.viewpager2.widget.ViewPager2
import com.heathcareinhand.ui.auth.LoginActivity


class IntroActivity : AppCompatActivity() {
    private lateinit var introAdapter: IntroAdapter

    private lateinit var binding: ActivityIntroBinding
    lateinit var introList: List<IntroModel>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        binding = DataBindingUtil.setContentView(this, R.layout.activity_intro)
        introList =listOf(
            IntroModel(resources.getDrawable(R.drawable.intro2), "Often when launching a tabbed activity, there needs to be a way to select a particular tab to be displayed "),
            IntroModel(resources.getDrawable(R.drawable.intro1), "Often when launching a tabbed activity, there needs to be a way to select a particular tab to be displayed "),
            IntroModel(resources.getDrawable(R.drawable.intro3), "Often when launching a tabbed activity, there needs to be a way to select a particular tab to be displayed "),
        )
        introAdapter = IntroAdapter(
            this, introList
        )
        binding.vpIntro.adapter = introAdapter


        binding.pageIndicatorView.count =introList.size

        binding.vpIntro.registerOnPageChangeCallback(object :ViewPager2.OnPageChangeCallback(){

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
                binding.pageIndicatorView.setSelected(position)
            }

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
            }

            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)
            }
        })

        binding.btnNext.setOnClickListener(View.OnClickListener {
            // checking for last page
            // if last page home screen will be launched
            val current: Int = binding.vpIntro.currentItem
            if (current < introList.size-1) {
                // move to next screen
                binding.vpIntro.setCurrentItem(current+1)
                binding.pageIndicatorView.setSelected(current+1)
            } else {
                launchHomeScreen()
            }
        })
    }

    fun launchHomeScreen() {
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }
}