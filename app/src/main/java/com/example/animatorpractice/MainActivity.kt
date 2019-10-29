package com.example.animatorpractice

import android.os.Bundle
import android.transition.Slide
import android.transition.TransitionManager
import android.view.Gravity
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var isTextVisible = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnOk.setOnClickListener {

            TransitionManager.beginDelayedTransition(vLinearLayout, Slide(Gravity.RIGHT))

            isTextVisible = !isTextVisible
            tvDemo.visibility = if (isTextVisible) View.GONE else View.VISIBLE

        }
    }
}