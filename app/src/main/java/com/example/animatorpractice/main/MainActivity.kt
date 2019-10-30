package com.example.animatorpractice.main

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import com.example.animatorpractice.R
import com.example.animatorpractice.detail.DetailActivity
import kotlinx.android.synthetic.main.activity_main.*
import androidx.core.util.Pair as AndroidxPair

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(vToolbar)

        btnOk.setOnClickListener {

            val imagePair = AndroidxPair.create(ivCat as View, getString(R.string.targetCat))
            val buttonPair = AndroidxPair.create(btnOk as View, getString(R.string.targetButton))

            val activityOptionsCompat = ActivityOptionsCompat
                .makeSceneTransitionAnimation(
                    this,
                    imagePair,
                    buttonPair
                )

            val intent = Intent(this, DetailActivity::class.java)
            startActivity(intent, activityOptionsCompat.toBundle())
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.item_settings) {
            Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }
}