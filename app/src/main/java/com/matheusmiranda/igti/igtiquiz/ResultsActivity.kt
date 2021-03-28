package com.matheusmiranda.igti.igtiquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results)

        // Receive Intent extra from Main Activity
        val numCorrect = intent.getIntExtra("ANSWERS", 0)
        val percentText = ((100 * numCorrect / 8)).toString() + "% de acertos"

        // Display it to the Text View
        val tvPercent: TextView = findViewById(R.id.tv_percent)
        tvPercent.text = percentText

        // Call Main Activity when button is clicked
        val btRestart: Button = findViewById(R.id.bt_restart)
        btRestart.setOnClickListener {
            Intent(this, MainActivity::class.java).also {
                startActivity(it)
                finish()
            }
        }
    }
}