package com.example.animatorpractice.demo

import android.os.Bundle
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.transition.AutoTransition
import androidx.transition.Explode
import androidx.transition.Fade
import androidx.transition.Scene
import androidx.transition.Slide
import androidx.transition.Transition
import androidx.transition.TransitionManager
import com.example.animatorpractice.R
import kotlinx.android.synthetic.main.start_layout.*

class DemoActivity : AppCompatActivity() {

    private lateinit var scene1: Scene
    private lateinit var scene2: Scene
    private lateinit var transition: Transition
    private var start: Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start_layout)

        val startViews = layoutInflater.inflate(R.layout.start_layout, base, false)
        val endViews = layoutInflater.inflate(R.layout.end_layout, base, false)

        scene1 = Scene(base, startViews)
        scene2 = Scene(base, endViews)

        transition = AutoTransition()
        transition.duration = 250
        transition.interpolator = AccelerateDecelerateInterpolator()
        start = true
    }

    fun changeScene(view: View) {
        if (start) {
            TransitionManager.go(scene2, transition)
            start = false
        } else {
            TransitionManager.go(scene1, transition)
            start = true
        }
    }
}
