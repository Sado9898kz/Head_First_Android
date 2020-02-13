package com.hfad.bitsandpizzas.Kotlin


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.ListFragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hfad.bitsandpizzas.Java.Pasta.pastas
import com.hfad.bitsandpizzas.R

/**
 * A simple [Fragment] subclass.
 */
class PastaFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val pizzaRecycler = inflater.inflate(R.layout.fragment_pizza, container, false) as RecyclerView

        val pizzaNames = arrayOfNulls<String>(pastas.size)
        for (it in pizzaNames.indices) {
            pizzaNames[it] = pastas[it].name
        }

        val pizzasImages = arrayOfNulls<Int>(pastas.size)
        for (it in pizzasImages.indices) {
            pizzasImages[it] = pastas[it].imageResourceId
        }

        val adapter = CaptionedImagesAdapter(pizzaNames, pizzasImages)
        pizzaRecycler.adapter = adapter
        val layoutManager = GridLayoutManager(activity, 2)
        pizzaRecycler.layoutManager = layoutManager
        return pizzaRecycler
    }
}
