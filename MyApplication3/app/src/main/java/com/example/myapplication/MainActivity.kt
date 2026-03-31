package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val editTextName = findViewById<EditText>(R.id.editTextName)
        val buttonProcess = findViewById<Button>(R.id.buttonProcess)
        val textViewResult = findViewById<TextView>(R.id.textViewResult)

        buttonProcess.setOnClickListener {
            val enteredText = editTextName.text.toString()
            if (enteredText.isNotEmpty()) {
                textViewResult.text = "Hello, $enteredText"
            } else {
                textViewResult.text = "Please enter some text"
            }
        }
    }
}