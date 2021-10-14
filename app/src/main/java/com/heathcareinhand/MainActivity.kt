package com.heathcareinhand

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.lifecycle.lifecycleScope
import com.heathcareinhand.ui.HomeActivity
import com.heathcareinhand.ui.intro.IntroActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
        setContentView(R.layout.activity_main)


        lifecycleScope.launch {
            delay(1000)
            withContext(Dispatchers.Main) {
                launchIntroScreen()
            }
        }
    }

    fun launchIntroScreen() {
        startActivity(Intent(this, IntroActivity::class.java))
        finish()
    }
}