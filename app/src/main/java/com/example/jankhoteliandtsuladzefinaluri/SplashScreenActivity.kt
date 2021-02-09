package com.example.jankhoteliandtsuladzefinaluri

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashScreenActivity : AppCompatActivity() {

    private val SPLASH_SCREEN_TIME: Long = 3000




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        supportActionBar?.hide()


        Handler().postDelayed({
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
            finish()
        }, SPLASH_SCREEN_TIME)

    }
}

