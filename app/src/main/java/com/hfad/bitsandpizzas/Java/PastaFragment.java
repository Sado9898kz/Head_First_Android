package com.hfad.bitsandpizzas.Java;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hfad.bitsandpizzas.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PastaFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView pizzaRecycler = (RecyclerView) inflater.inflate(
                R.layout.fragment_pizza, container, false);

        String[] pizzaNames = new String[Pasta.pastas.length];
        for (int i = 0; i < pizzaNames.length; i++) {
            pizzaNames[i] = Pasta.pastas[i].getName();
        }

        int[] pizzasImages = new int[Pasta.pastas.length];
        for (int i = 0; i < pizzasImages.length; i++) {
            pizzasImages[i] = Pasta.pastas[i].getImageResourceId();
        }

        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(pizzaNames, pizzasImages);
        pizzaRecycler.setAdapter(adapter);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        pizzaRecycler.setLayoutManager(layoutManager);
        return pizzaRecycler;
    }
}
