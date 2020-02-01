package com.hfad.workout.Kotlin


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.hfad.workout.R
import kotlinx.android.synthetic.main.fragment_workout_detail.*

/**
 * A simple [Fragment] subclass.
 */
class WorkoutDetailFragment : Fragment() {
    private var workoutId: Long = 0

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

    fun setWorkout(id: Long) {
        this.workoutId = id
    }
}
