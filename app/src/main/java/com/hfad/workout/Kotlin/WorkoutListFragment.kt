package com.hfad.workout.Kotlin


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.fragment.app.ListFragment

/**
 * A simple [Fragment] subclass.
 */
class WorkoutListFragment : ListFragment() {

    interface Listener {
        fun itemClicked(id: Long)
    }

    private var listener: Listener? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val names = arrayOfNulls<String>(Workout.workouts.size)
        for (i in 0..names.size) {
            names[i] = Workout.workouts[i].name
        }

        val adapter = ArrayAdapter<String>(inflater.context, android.R.layout.simple_list_item_1)
        listAdapter = adapter
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.listener = context as Listener
    }

    override fun onListItemClick(l: ListView, v: View, position: Int, id: Long) {
        if (listener != null) {
            listener!!.itemClicked(id)
        }
    }
}
