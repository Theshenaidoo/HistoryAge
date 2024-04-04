package com.example.historyage

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var search: Button
    private lateinit var clear: Button
    private lateinit var welcome: TextView
    private lateinit var ageInput: EditText
    private lateinit var age: TextView
    private lateinit var output: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->

            // Initialize
            search = findViewById(R.id.Search)
            clear = findViewById(R.id.Clear)
            ageInput = findViewById(R.id.AgeInput)
            output = findViewById(R.id.Output)
            clear.setOnClickListener { ageInput.text.clear()
            output.text = ""

            }

            // Set onClickListener for Search button
            search.setOnClickListener {
                val age = ageInput.text.toString().toIntOrNull()

                if (age != null && age in 20..100) {
                    val historicName = when (age) {
                        42 -> "Elvis Presley"
                        50 -> "Michael Jackson"
                        52 -> "William Shakespeare"
                        53 -> "George Michael"
                        56 -> "Abraham Lincoln"
                        66 -> "Kevin Conroy"
                        67 -> "George Washington"
                        76 -> "Aretha Franklin"
                        85 -> "Benjamin Franklin"
                        95 -> "Nelson Mandela"
                        else -> null
                    }
                    val message = historicName?.let {
                        "Your age matches $it when they died."
                    } ?: "No Historic Figure found."
                    output.text = message
                } else {
                    output.text = "Invalid input. Please enter a valid age"
                }
            }

            insets
        }
    }
}
