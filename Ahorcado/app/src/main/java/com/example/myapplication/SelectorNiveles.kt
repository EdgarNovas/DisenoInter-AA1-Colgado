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
            Level(getString(R.string.level) + " 1 ",R.drawable.ahorcado, "Gato"),
            Level(getString(R.string.level) + " 2 ", R.drawable.ic_launcher_foreground, "Perro"),
            Level(getString(R.string.level) + " 3 ", R.drawable.ahorcado, "LOL"),
            Level(getString(R.string.level) + " 4 ", R.drawable.ic_launcher_foreground, "Extraer"),
            Level(getString(R.string.level) + " 5 ", R.drawable.ahorcado, "Ventilador"),
            Level(getString(R.string.level) + " 6 ", R.drawable.ic_launcher_foreground, "Ventilador"),
            Level(getString(R.string.level) + " 7 ", R.drawable.ahorcado, "Ventilador"),
            Level(getString(R.string.level) + " 8 ", R.drawable.ic_launcher_foreground, "Ventilador"),
            Level(getString(R.string.level) + " 9 ", R.drawable.ahorcado, "Ventilador"),
            Level(getString(R.string.level) + " 10 ", R.drawable.ic_launcher_foreground, "Ventilador"),
            Level(getString(R.string.level) + " 11 ", R.drawable.ahorcado, "Ventilador"),
            Level(getString(R.string.level) + " 12 ", R.drawable.ic_launcher_foreground, "Ventilador")

        )

        recyclerView.adapter = LevelAdapter(levels)

    }
}