package com.example.sparkproject

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity () {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

         }

        val editText = findViewById<EditText>(R.id.editText)
        val getCue= findViewById<Button>(R.id.getCue)
        val clearBtn = findViewById<Button>(R.id.clearBtn)
        val exitBTN = findViewById<Button>(R.id.exitBtn)
        val chronoSpark = findViewById<TextView>(R.id.textView)

        getCue.setOnClickListener{
            val time = editText.text.toString().trim().lowercase()
            val finalMessage: String

            if (time == "morning") {
                finalMessage = "Send a 'Good morning' text to a family member."
            }
            else if (time == "mid-morning") {
                finalMessage = "Reach out to a colleague with a quick 'Thank you'."
            }
            else if (time == "afternoon") {
                finalMessage = "Share a funny meme or interesting link with a friend."
            }
            else if (time == "afternoon snack time") {
                finalMessage = "Send a quick 'thinking of you' message."
            }
            else if (time == "dinner") {
                finalMessage = "Call a friend or relative for a 5-minute catch-up."
            }
            else if (time == "after dinner" || time == "night") {
                finalMessage = "Leave a thoughtful comment on a friend's post."
            }
            else if (time.isEmpty()) {
                finalMessage = "Please enter a time of day to receive a suggestion."
            }
            else {
                finalMessage = "Unrecognized time. Try writing 'Morning' or 'Afternoon' to help Cora!"
            }

            chronoSpark.text = finalMessage
        }

        clearBtn.setOnClickListener {
            editText.text.clear()
            chronoSpark.text = ""


        }
        exitBTN.setOnClickListener {
            finish()
        }

    }
}