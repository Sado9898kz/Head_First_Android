package com.hfad.bitsandpizzas.Kotlin


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.hfad.bitsandpizzas.R

/**
 * A simple [Fragment] subclass.
 */
class TopFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_top, container, false)
    }
}