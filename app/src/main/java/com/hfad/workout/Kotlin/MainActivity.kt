package com.hfad.workout.Kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.hfad.workout.R

class MainActivity : AppCompatActivity(), WorkoutListFragment.Listener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onShowDetails(view: View) {
        val intent = Intent(this@MainActivity, DetailActivity::class.java)
        startActivity(intent)
    }

    override fun itemClicked(id: Long) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(DetailActivity().EXTRA_WORKOUT_ID, id)
        startActivity(intent)
    }
}