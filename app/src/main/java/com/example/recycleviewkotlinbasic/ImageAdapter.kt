package com.example.recycleviewkotlinbasic

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ImageAdapter(
    private val listImage : List<Int>
) : RecyclerView.Adapter<ImageAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.adapter_image, parent, false)
    )

    override fun onBindViewHolder(holder: ImageAdapter.ViewHolder, position: Int) {
        holder.image.setImageResource(listImage[position])
    }

    override fun getItemCount() = listImage.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image = view.findViewById<ImageView>(R.id.imageView)
    }
}