package com.example.cokothon.presentation

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.cokothon.R
import com.example.cokothon.core.base.BindingActivity
import com.example.cokothon.databinding.ActivityQuestionResult2Binding

class QuestionResult2Activity : BindingActivity<ActivityQuestionResult2Binding>(R.layout.activity_question_result_2) {
    private lateinit var tvQuestionTitle: TextView
    private lateinit var tvAnswers: TextView
    private lateinit var btnNext: Button

    override fun initView() {
        // Initialize views using view binding
        tvQuestionTitle = binding.tvQuestionTitle
        tvAnswers = binding.tvAnswers
        btnNext = binding.btnNext

        // Assume you have a method to get answer data from the backend
        val answers: List<Pair<String, String>> = answersFromBackend()

        // Set temporary question title
        tvQuestionTitle.text = "이곳은 두번째 질문 자리 입니다"

        // Display answers
        displayAnswers(answers)

        // Set click listener for the next button
        btnNext.setOnClickListener {
            startActivity(Intent(this, QuestionResult3Activity::class.java))
        }
    }

    private fun answersFromBackend(): List<Pair<String, String>> {
        // Assume A, B, C, D, E each answered 1, 2, 3, 4, 5 respectively
        return listOf(
            Pair("A", "1"),
            Pair("B", "2"),
            Pair("C", "3"),
            Pair("D", "4"),
            Pair("E", "5")
        )
    }

    private fun displayAnswers(answers: List<Pair<String, String>>) {
        val answersText = StringBuilder()

        // Iterate through answers and append to the StringBuilder
        for ((username, answerContent) in answers) {
            answersText.append("$username : $answerContent\n")
        }

        // Set the text to the TextView
        tvAnswers.text = answersText.toString()
    }
}
