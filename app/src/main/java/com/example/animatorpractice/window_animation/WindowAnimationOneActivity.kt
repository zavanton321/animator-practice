package com.example.animatorpractice.window_animation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.animatorpractice.R
import kotlinx.android.synthetic.main.activity_custom_start.*

class WindowAnimationOneActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_start)

        ivTarget.setOnClickListener {
            Intent(this, WindowAnimationTwoActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}
