package com.example.proyect

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Obtener referencia al botón
        val startButton: Button = findViewById(R.id.startButton)

        // Configurar el click listener para el botón
        startButton.setOnClickListener {
            // Lógica para iniciar una nueva Activity
            val intent = Intent(this, PrimeraPantallaActivity::class.java)
            startActivity(intent)
        }
    }
}