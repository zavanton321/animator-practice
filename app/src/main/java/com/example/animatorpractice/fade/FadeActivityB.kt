package com.example.animatorpractice.fade

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.animatorpractice.R

class FadeActivityB : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_end)

        overridePendingTransition(R.anim.fadein, R.anim.fadeout)
    }

    override fun onPause() {
        super.onPause()

        overridePendingTransition(R.anim.fadein, R.anim.fadeout)
    }
}
