package com.hfad.workout.Kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentTransaction
import com.hfad.workout.R
import kotlinx.android.synthetic.main.activity_main.*

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
        val fragmentContainer = fragment_container
        if (fragmentContainer != null) {
            val details = WorkoutDetailFragment()

            val ft = supportFragmentManager.beginTransaction()
            details.setWorkout(id)

            ft.replace(R.id.fragment_container, details)

            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)

            ft.addToBackStack(null)

            ft.commit()
        } else {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra(DetailActivity().EXTRA_WORKOUT_ID, id)
            startActivity(intent)
        }
    }
}