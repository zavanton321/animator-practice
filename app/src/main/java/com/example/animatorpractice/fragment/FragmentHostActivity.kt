package com.example.animatorpractice.fragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.animatorpractice.R
import kotlinx.android.synthetic.main.activity_fragment_host.*

class FragmentHostActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_host)

        addFragment(savedInstanceState)

        fragmentHost.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentHost, FragmentB.newInstance())
                .addToBackStack(null)
                .commit()
        }
    }

    private fun addFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            if (supportFragmentManager.findFragmentById(R.id.fragmentHost) == null) {
                supportFragmentManager.beginTransaction()
                    .add(R.id.fragmentHost, FragmentA.newInstance())
                    .commit()
            }
        }
    }
}
