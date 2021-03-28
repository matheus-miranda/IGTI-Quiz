package com.matheusmiranda.igti.igtiquiz

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var mCurrentPosition: Int = 1 // Current question ID
    private lateinit var mQuestionsList: ArrayList<Question>
    private var mAnswer: Boolean? = null // True or False answer to each question
    private var mCorrectAnswers: Int = 0 // Number of correct answers by user

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        splashScreenCall()
        getCurrentQuestion()
        recordAnswers()
    }

    /**
     * Calls the Splash Screen Activity on first login
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

    /**
     * Gets the info for the current question and populates TextView until the end of the
     * Question list size
     */
    private fun getCurrentQuestion() {
        mQuestionsList = Constants.getQuestions()

        if (mCurrentPosition <= mQuestionsList.size) {
            val question: Question = mQuestionsList[mCurrentPosition - 1] // Get 1st position
            mAnswer = question.answer

            val tvQuestion: TextView = findViewById(R.id.tv_question)
            tvQuestion.text = question.question // Sets 1st question to the text view
        } else {
            callResultsActivity()
        }
    }

    /**
     * Saves each correct answer from user and repopulates TextView with new question
     */
    private fun recordAnswers() {
        val btTrue: Button = findViewById(R.id.bt_true)
        val btFalse: Button = findViewById(R.id.bt_false)

        btTrue.setOnClickListener {
            if (mAnswer == true) {
                mCorrectAnswers++
            }
            mCurrentPosition++
            getCurrentQuestion()
        }

        btFalse.setOnClickListener {
            if (mAnswer == false) {
                mCorrectAnswers++
            }
            mCurrentPosition++
            getCurrentQuestion()
        }
    }

    /**
     * Calls the Results Activity and passes number of correct Answers
     */
    private fun callResultsActivity() {
        Intent(this, ResultsActivity::class.java).also {
            it.putExtra("ANSWERS", mCorrectAnswers)
            startActivity(it)
        }
        finish()
    }
}
