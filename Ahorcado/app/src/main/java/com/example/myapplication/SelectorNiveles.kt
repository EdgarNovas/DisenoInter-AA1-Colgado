package com.example.myapplication

import HangLevels.Level
import HangLevels.LevelAdapter
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class SelectorNiveles : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selector_niveles)

        val recyclerView = findViewById<RecyclerView>(R.id.levelRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val levels = listOf(
            Level("Level 1 ",R.drawable.ahorcado, "Gato"),
            Level("Level 2 ", R.drawable.ic_launcher_foreground, "Perro"),
            Level("Level 3 ", R.drawable.ahorcado, "LOL"),
            Level("Level 4 ", R.drawable.ic_launcher_foreground, "Extraer"),
            Level("Level 5 ", R.drawable.ahorcado, "Ventilador"),
            Level("Level 6 ", R.drawable.ic_launcher_foreground, "Ventilador"),
            Level("Level 7 ", R.drawable.ahorcado, "Ventilador"),
            Level("Level 8 ", R.drawable.ic_launcher_foreground, "Ventilador"),
            Level("Level 9 ", R.drawable.ahorcado, "Ventilador"),
            Level("Level 10 ", R.drawable.ic_launcher_foreground, "Ventilador"),
            Level("Level 11 ", R.drawable.ahorcado, "Ventilador"),
            Level("Level 12 ", R.drawable.ic_launcher_foreground, "Ventilador")

        )

        recyclerView.adapter = LevelAdapter(levels)

    }
}