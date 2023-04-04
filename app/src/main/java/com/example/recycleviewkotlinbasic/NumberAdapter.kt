package com.example.recycleviewkotlinbasic

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NumberAdapter(
    private val listName : List<Int>
) : RecyclerView.Adapter<NumberAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.adapter_main, parent, false)
    )

    override fun onBindViewHolder(holder: NumberAdapter.ViewHolder, position: Int) {
//        holder.text.text = listName[position]
        holder.text.text = listName[position].toString()
    }

    override fun getItemCount() = listName.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val text = view.findViewById<TextView>(R.id.textView)
    }
}