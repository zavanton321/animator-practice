package com.example.animatorpractice.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.animatorpractice.R

class HostActivity : AppCompatActivity(), StartFragment.FragmentNavigator {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_host)

        addFragment(savedInstanceState)
    }

    override fun goToFinishFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fmtContainer, FinishFragment.newInstance())
            .addToBackStack(null)
            .commit()
    }

    private fun addFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            if (supportFragmentManager.findFragmentById(R.id.fmtContainer) == null) {
                supportFragmentManager.beginTransaction()
                    .add(R.id.fmtContainer, StartFragment.newInstance())
                    .commit()
            }
        }
    }
}
