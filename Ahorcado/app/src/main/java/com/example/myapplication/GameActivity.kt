package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class GameActivity : AppCompatActivity() {

    lateinit var hiddenWordText: TextView
    lateinit var letterInput : EditText
    var guessedWord : String = ""
    var failedAttempts : Int = 0
    val maxAttempts : Int = 6
    lateinit var palabraAdivinar: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        hiddenWordText = findViewById(R.id.wordGame)
        letterInput = findViewById(R.id.letterInput)



        palabraAdivinar = intent.getStringExtra("PalabraAdivinar") ?.uppercase() ?: "" /// Si hago !! es para que crashee si es null

        guessedWord = "_".repeat(palabraAdivinar.length)

        hiddenWordText.text = guessedWord.toCharArray().joinToString(" ")

        //findViewById<TextView>(R.id.wordGame).text = palabraAdivinar

        findViewById<Button>(R.id.tryButton).setOnClickListener {
            var letter = letterInput.text.toString().uppercase()
            if(letter.isNotEmpty()){
                checkLetter(letter[0])
                letterInput.text.clear()
            }
        }
    }


    private fun checkLetter(letter: Char) {
        var updated = guessedWord.toCharArray()
        var correctGuess = false
        //Ayudado por ChatGPT
        for (i in palabraAdivinar.indices) {
            if (palabraAdivinar[i] == letter) {
                updated[i] = letter
                correctGuess = true
            }
        }

        if(correctGuess)
        {
            guessedWord = String(updated)
            hiddenWordText.text = guessedWord.toCharArray().joinToString(" ")
            if(!guessedWord.contains('_'))
            {
                Toast.makeText(this, "You WIN!", Toast.LENGTH_LONG).show()
                finish() //Ir al selector de niveles
            }
        }
        else
        {
            failedAttempts++

            if(failedAttempts >= maxAttempts)
            {
                Toast.makeText(this, "You LOSE! La palabra era $palabraAdivinar", Toast.LENGTH_LONG).show()
                finish()
            }
        }

    }
}