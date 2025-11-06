package com.example.myapplication

import HangLevels.Level
import HangLevels.LevelAdapter
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatDelegate

class SelectorNiveles : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selector_niveles)

        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return  when (item.itemId){
            R.id.action_settings -> {
                showThemeDialog()
                true

            }
            else -> super.onOptionsItemSelected(item)
        }


    }


    private fun showThemeDialog() {
        val options = arrayOf("Light Mode", "Dark Mode")
        AlertDialog.Builder(this)
            .setTitle("Select Theme")
            .setItems(options) { _, which ->
                when (which) {
                    0 -> setThemeMode(AppCompatDelegate.MODE_NIGHT_NO)
                    1 -> setThemeMode(AppCompatDelegate.MODE_NIGHT_YES)
                }
            }
            .show()
    }

    private fun setThemeMode(mode: Int) {
        val prefs = getSharedPreferences("settings", MODE_PRIVATE)
        prefs.edit().putInt("theme_mode", mode).apply()
        AppCompatDelegate.setDefaultNightMode(mode)
    }

}