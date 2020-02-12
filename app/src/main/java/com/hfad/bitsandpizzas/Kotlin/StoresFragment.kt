package com.hfad.bitsandpizzas.Kotlin


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.fragment.app.ListFragment
import com.hfad.bitsandpizzas.R

/**
 * A simple [ListFragment] subclass.
 */
class StoresFragment : ListFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val adapter = ArrayAdapter<String>(
                inflater.context,
                android.R.layout.simple_list_item_1,
                resources.getStringArray(R.array.stores)
        )
        listAdapter = adapter
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}
