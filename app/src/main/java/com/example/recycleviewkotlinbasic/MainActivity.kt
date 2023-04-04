package com.example.recycleviewkotlinbasic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val image = listOf<Int>(
            R.drawable.captain_america,
            R.drawable.iron_man,
            R.drawable.thor,
            R.drawable.captain_marvel
        )
        val imageAdapter = ImageAdapter( image )
        findViewById<RecyclerView>(R.id.recycleView).adapter = imageAdapter

//        findViewById<ImageView>(R.id.imageView).setImageResource(R.drawable.captain_america)
//        textAdapter()
//        numberAdapter()
    }

    private fun textAdapter(){
        val names = listOf<String>(
            "Nur",
            "Lisa",
            "Uwais",
            "Umar",
            "Iswanto",
            "Mufia",
            "Abdurrahman",
            "Alfarisiy"
        )

        val textAdapter = TextAdapter( names )
        findViewById<RecyclerView>(R.id.recycleView).adapter = textAdapter

        Log.e("MainActivity","size $names.size")
        Log.e("MainActivity", names[0])

        names.forEach {
            Log.e("MainActivity", it)
        }

        names.forEach {name ->
            Log.e("MainActivity", name)
        }
    }

    private fun numberAdapter(){
        val numbers = listOf<Int>(
            1,
            2,
            3,
            4,
            5,
            6,
            7,
            8,
            9
        )

        val numberAdapter = NumberAdapter( numbers )
        findViewById<RecyclerView>(R.id.recycleView).adapter = numberAdapter
    }
}