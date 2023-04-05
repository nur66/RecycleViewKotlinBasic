package com.example.recycleviewkotlinbasic

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class TextAdapter(
    private val listName : List<String>
) : RecyclerView.Adapter<TextAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.adapter_main, parent, false)
    )

    override fun onBindViewHolder(holder: TextAdapter.ViewHolder, position: Int) {
        holder.textView.text = listName[position]
        val name = listName[position]
        holder.textView.setOnClickListener {
            Log.i("TextAdapter", name)
        }
//        holder.container.setOnClickListener {
//            Log.e("TextAdapter", name)
//        }
    }

    override fun getItemCount() = listName.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView = view.findViewById<TextView>(R.id.textView)
        val container = view.findViewById<ConstraintLayout>(R.id.container)
    }
}