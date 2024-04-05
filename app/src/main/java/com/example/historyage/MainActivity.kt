package com.example.historyage

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat


class MainActivity : AppCompatActivity() {

    private lateinit var search: Button
    private lateinit var clear: Button

    private lateinit var ageInput: EditText

    private lateinit var output: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { _, insets ->

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
                        42 -> "Elvis Presley whom was a famous,influential and controversial singer"
                        50 -> "Michael Jackson whom was referred as the king of pop and the greatest artist of all time"
                        52 -> "William Shakespeare whom was a famous and talented writer"
                        53 -> "George Michael whom was a talented singer"
                        56 -> "Abraham Lincoln whom was a lawyer,politician and statesman who served as the 16th president of USA"
                        66 -> "Kevin Conroy whom was a iconic voice actor of Batman"
                        67 -> "George Washington whom was the first president of USA"
                        76 -> "Aretha Franklin whom was referred as the greatest female singer of all time"
                        85 -> "Benjamin Franklin whom was a famous inventor and philanthropist"
                        95 -> "Nelson Mandela whom was a politician that helped the struggle to end apartheid"
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
