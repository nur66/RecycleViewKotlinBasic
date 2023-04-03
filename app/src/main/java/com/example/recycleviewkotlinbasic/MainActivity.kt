package com.example.recycleviewkotlinbasic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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

        val mainAdapter = MainAdapter( names )
        findViewById<RecyclerView>(R.id.recycleView).adapter = mainAdapter
    }
}