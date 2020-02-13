package com.hfad.bitsandpizzas.Kotlin


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hfad.bitsandpizzas.Java.Pizza.pizzas
import com.hfad.bitsandpizzas.R

/**
 * A simple [Fragment] subclass.
 */
class PizzaFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val pizzaRecycler = inflater.inflate(R.layout.fragment_pizza, container, false) as RecyclerView

        val pizzaNames = arrayOf<String>()
        for (it in 0..pizzas.size) {
            pizzaNames[it] = pizzas[it].name
        }

        val pizzasImages = arrayOf<Int>()
        for (it in 0..pizzas.size) {
            pizzasImages[it] = pizzas[it].imageResourceId
        }

        val adapter = CaptionedImagesAdapter(pizzaNames, pizzasImages)
        pizzaRecycler.adapter = adapter
        val layoutManager = GridLayoutManager(activity, 2)
        pizzaRecycler.layoutManager = layoutManager
        return pizzaRecycler
    }
}