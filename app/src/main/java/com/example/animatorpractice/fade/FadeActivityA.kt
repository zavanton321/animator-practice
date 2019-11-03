package com.example.animatorpractice.fade

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.animatorpractice.R
import kotlinx.android.synthetic.main.activity_custom_start.*

class FadeActivityA : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_start)

        overridePendingTransition(R.anim.fadein, R.anim.fadeout)

        ivTarget.setOnClickListener {
            Intent(this, FadeActivityB::class.java).also {
                startActivity(it)
            }
        }
    }

    override fun onPause() {
        super.onPause()

        overridePendingTransition(R.anim.fadein, R.anim.fadeout)
    }
}
