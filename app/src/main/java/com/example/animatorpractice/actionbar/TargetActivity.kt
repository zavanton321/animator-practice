package com.example.animatorpractice.actionbar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.animatorpractice.R

class TargetActivity : AppCompatActivity(), FragmentOne.FragmentNavigator {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_target)

        addFragment(savedInstanceState)
    }

    override fun goToFragmentTwo() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fmtContainer, FragmentTwo.newInstance())
            .addToBackStack(null)
            .commit()
    }

    private fun addFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            if (supportFragmentManager.findFragmentById(R.id.fmtContainer) == null) {
                supportFragmentManager.beginTransaction()
                    .add(R.id.fmtContainer, FragmentOne.newInstance())
                    .commit()
            }
        }
    }
}