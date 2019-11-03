package com.example.animatorpractice.transition

import android.content.Intent
import android.os.Bundle
import android.transition.TransitionInflater
import androidx.appcompat.app.AppCompatActivity
import com.example.animatorpractice.R
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        setupExitTransition()
        setupButton()
    }

    private fun setupExitTransition() {
        val slide = TransitionInflater.from(this)
            .inflateTransition(R.transition.transition_slide)
        window.exitTransition = slide
    }

    private fun setupButton() {
        btnGo.setOnClickListener {
            Intent(this, ItemActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}
