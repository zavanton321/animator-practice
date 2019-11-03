package com.example.animatorpractice.manager

import android.os.Bundle
import android.view.View
import android.view.animation.DecelerateInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.transition.ChangeBounds
import androidx.transition.Explode
import androidx.transition.Scene
import androidx.transition.TransitionInflater
import androidx.transition.TransitionManager
import androidx.transition.TransitionSet
import com.example.animatorpractice.R
import kotlinx.android.synthetic.main.activity_custom_start.*

class ManagerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_start)

        ivTarget.setOnClickListener {

            demoOne()
            // demoTwo()
        }
    }

    private fun demoOne() {
        // Create a scene via constructor
        val layout: View =
            layoutInflater.inflate(R.layout.activity_custom_end, vContainer, false)
        val scene = Scene(vContainer, layout)

        // Create TransitionSet programmatically
        val transitionSet = TransitionSet()
        transitionSet.addTransition(ChangeBounds())
        transitionSet.addTransition(Explode())
        transitionSet.interpolator = DecelerateInterpolator()
        transitionSet.ordering = TransitionSet.ORDERING_TOGETHER

        TransitionManager.go(scene, transitionSet)
    }

    private fun demoTwo() {
        // Create a scene via a static method
        val scene: Scene = Scene.getSceneForLayout(vContainer, R.layout.activity_custom_end, this)

        // Create TransitionSet from resource
        val transitionSet: TransitionSet = TransitionInflater.from(this)
            .inflateTransition(R.transition.complex_transition) as TransitionSet

        TransitionManager.go(scene, transitionSet)
    }
}