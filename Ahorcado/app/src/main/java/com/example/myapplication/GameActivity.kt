package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.GridLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
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
        //letterInput = findViewById(R.id.letterInput)

        val keyboardLayout = findViewById<GridLayout>(R.id.keyboardLayout)

        palabraAdivinar = intent.getStringExtra("PalabraAdivinar") ?.uppercase() ?: "" /// Si hago !! es para que crashee si es null

        guessedWord = "_".repeat(palabraAdivinar.length)

        hiddenWordText.text = guessedWord.toCharArray().joinToString(" ")

        // ✅ Crear botones de la A a la Z
        for (c in 'A'..'Z') {
            val button = Button(this)
            button.text = c.toString()
            button.textSize = 16f

            val params = GridLayout.LayoutParams()
            params.width = 0
            params.height = GridLayout.LayoutParams.WRAP_CONTENT
            params.columnSpec = GridLayout.spec(GridLayout.UNDEFINED, 1f)
            params.setMargins(4, 4, 4, 4)
            button.layoutParams = params
            button.setOnClickListener {
                CheckLetter(c)
                button.isEnabled = false // Desactiva la letra ya usada
            }
            keyboardLayout.addView(button)
        }
    }


    private fun CheckLetter(letter: Char) {
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
                ShowResultDialog(true)
                //Toast.makeText(this, "You WIN!", Toast.LENGTH_LONG).show()
                //finish() //Ir al selector de niveles
            }
        }
        else
        {
            failedAttempts++

            if(failedAttempts >= maxAttempts)
            {
                ShowResultDialog(false)
                //Toast.makeText(this, "You LOSE! La palabra era $palabraAdivinar", Toast.LENGTH_LONG).show()
                //finish()
            }
        }

    }


    fun ShowResultDialog(win : Boolean)
    {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.result, null)
        var resultText = dialogView.findViewById<TextView>(R.id.resultText)
        resultText.text = if(win) "Nice, You won this game"
        else "You have lost la palabra era $palabraAdivinar"

        val dialog = AlertDialog.Builder(this).setView(dialogView)
            .setCancelable(true)
            .create()

        dialog.show()
        dialog.window?.setDimAmount(0.8f)
        
        dialogView.setOnClickListener {
            dialog.dismiss()
            finish()
        }

        dialog.setOnDismissListener {
            finish()
        }
    }
}