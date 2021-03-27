package com.matheusmiranda.igti.igtiquiz

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        splashScreenCall() // Call Splash Screen if first login


    }

    /**
     * Calls the Splash Screen Activity
     */
    private fun splashScreenCall() {
        val sharedPref: SharedPreferences = getSharedPreferences("PREFS", MODE_PRIVATE)
        val firstTime = sharedPref.getBoolean("FIRST_TIME", true)

        if (firstTime) {
            val editor: SharedPreferences.Editor = sharedPref.edit()
            editor.putBoolean("FIRST_TIME", false)
            editor.apply()

            Intent(this, SplashScreenActivity::class.java).also {
                startActivity(it)
                finish()
            }
        }
    }
}
