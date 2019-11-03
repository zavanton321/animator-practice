package com.example.animatorpractice.custom

import android.os.Bundle
import android.view.animation.DecelerateInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.transition.Explode
import androidx.transition.Scene
import androidx.transition.Transition
import androidx.transition.TransitionManager
import com.example.animatorpractice.R
import kotlinx.android.synthetic.main.activity_custom_start.*

class CustomActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_start)

        val endLayout = layoutInflater.inflate(R.layout.activity_custom_end, vContainer, false)
        val endScene = Scene(vContainer, endLayout)

        val transition: Transition = Explode()
        transition.duration = 250
        transition.startDelay = 100
        transition.interpolator = DecelerateInterpolator()

        ivTarget.setOnClickListener {
            TransitionManager.go(endScene, transition)
        }
    }
}