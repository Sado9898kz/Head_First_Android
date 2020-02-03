package com.hfad.workout.Kotlin


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.fragment.app.ListFragment
import com.hfad.workout.R

/**
 * A simple [Fragment] subclass.
 */
class WorkoutListFragment : ListFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val names = arrayOfNulls<String>(Workout.workouts.size)
        for (i in 0..names.size) {
            names[i] = Workout.workouts[i].name
        }

        val adapter = ArrayAdapter<String>(inflater.context, android.R.layout.simple_list_item_1)
        listAdapter = adapter
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}
