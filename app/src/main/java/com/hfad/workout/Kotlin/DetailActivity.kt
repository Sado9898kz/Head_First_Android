package com.hfad.workout.Kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hfad.workout.R

class DetailActivity : AppCompatActivity() {

    val EXTRA_WORKOUT_ID = "id"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val frag = supportFragmentManager.findFragmentById(R.id.detail_frag) as WorkoutDetailFragment
        val workoutId = intent.extras!![EXTRA_WORKOUT_ID] as Long
        frag.setWorkout(workoutId)
    }
}
