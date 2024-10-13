package com.example.proyect

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider

class ResultadoActivity : AppCompatActivity() {

    private lateinit var viewModel: UsuarioViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        viewModel = ViewModelProvider(this).get(UsuarioViewModel::class.java)

        val peso = intent.getFloatExtra("peso", 0f)
        val estatura = intent.getFloatExtra("estatura", 0f)

        val imc = viewModel.calcularIMC(peso, estatura)
        val clasificacion = viewModel.obtenerClasificacionIMC(imc)

        findViewById<TextView>(R.id.imcTextView).text = "Tu IMC es: $imc"
        findViewById<TextView>(R.id.clasificacionTextView).text = "Clasificación: $clasificacion"
    }
}