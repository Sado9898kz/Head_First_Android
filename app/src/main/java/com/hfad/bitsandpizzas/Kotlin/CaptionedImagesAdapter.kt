package com.hfad.bitsandpizzas.Kotlin

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.hfad.bitsandpizzas.R

class CaptionedImagesAdapter(private val captions: Array<String?>, private val imageIds: Array<Int?>) : RecyclerView.Adapter<CaptionedImagesAdapter.ViewHolder>() {

    class ViewHolder(val cardView: CardView) : RecyclerView.ViewHolder(cardView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val cv = LayoutInflater.from(parent.context)
                .inflate(R.layout.card_captioned_image, parent, false) as CardView
        return ViewHolder(cv)
    }

    override fun getItemCount(): Int = captions.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cardView = holder.cardView
        val imageView = cardView.findViewById<ImageView>(R.id.info_image)
        val drawable = ContextCompat.getDrawable(cardView.context, imageIds[position]!!)
        imageView.setImageDrawable(drawable)
        imageView.contentDescription = captions[position]
        val textView = cardView.findViewById<TextView>(R.id.info_text)
        textView.text = captions[position]
    }
}