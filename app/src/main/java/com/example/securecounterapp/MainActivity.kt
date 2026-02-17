package com.example.securecounterapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private var counter = 0
    private lateinit var counterText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        counterText = findViewById(R.id.counterText)
        val btnIncrease = findViewById<Button>(R.id.btnIncrease)
        val btnDecrease = findViewById<Button>(R.id.btnDecrease)
        val btnReset = findViewById<Button>(R.id.btnReset)

        updateCounter()

        btnIncrease.setOnClickListener {
            counter++
            Log.i("SecureCounterApp", "Counter increased to $counter")
            updateCounter()
        }

        btnDecrease.setOnClickListener {
            if (counter > 0) {
                counter--
                Log.i("SecureCounterApp", "Counter decreased to $counter")
                updateCounter()
            } else {
                Toast.makeText(this, "Counter cannot go below zero!", Toast.LENGTH_SHORT).show()
                Log.w("SecureCounterApp", "Attempted negative counter")
            }
        }

        btnReset.setOnClickListener {
            counter = 0
            Log.i("SecureCounterApp", "Counter reset")
            updateCounter()
        }
    }

    private fun updateCounter() {
        counterText.text = counter.toString()
    }
}
