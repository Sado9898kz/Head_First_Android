package com.hfad.workout.Kotlin


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentTransaction
import com.hfad.workout.R
import kotlinx.android.synthetic.main.fragment_workout_detail.*

/**
 * A simple [Fragment] subclass.
 */
class WorkoutDetailFragment : Fragment() {
    private var workoutId: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            val stopwatch = StopwatchFragment()
            val ft = childFragmentManager.beginTransaction()
            ft.add(R.id.stopwatch_container, stopwatch)
            ft.addToBackStack(null)
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            ft.commit()
        } else {
            workoutId = savedInstanceState.getLong("workoutId")
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_workout_detail, container, false)
    }

    override fun onStart() {
        super.onStart()
        val view = view ?: return
        val title = textTitle
        val workout = Workout.workouts[workoutId.toInt()]
        title.text = workout.name
        val description = textDescription
        description.text = workout.description
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putLong("workoutId", workoutId)
    }

    fun setWorkout(id: Long) {
        this.workoutId = id
    }
}
