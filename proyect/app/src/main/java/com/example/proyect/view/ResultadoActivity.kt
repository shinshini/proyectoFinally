package com.example.proyect.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.proyect.R
import com.example.proyect.viewmodel.UsuarioViewModel

class ResultadoActivity : AppCompatActivity() {

    private lateinit var viewModel: UsuarioViewModel
    private lateinit var objetivo: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        viewModel = ViewModelProvider(this).get(UsuarioViewModel::class.java)

        // Obtener los valores de nombre, genero, fecha de nacimiento, peso y estatura
        val nombre = intent.getStringExtra("nombre")
        val genero = intent.getStringExtra("genero")
        val fechaNacimiento = intent.getStringExtra("fechaNacimiento")
        val peso = intent.getFloatExtra("peso", 0f)
        val estatura = intent.getFloatExtra("estatura", 0f)

        // Calcular el IMC
        val imc = viewModel.calcularIMC(peso, estatura)

        // Mostrar el IMC en el TextView
        findViewById<TextView>(R.id.imcTextView).text = "Tu IMC es: $imc"

        // Obtener la sugerencia de objetivo basada en el IMC
        objetivo = obtenerSugerenciaObjetivo(imc)

        // Mostrar la sugerencia al usuario
        findViewById<TextView>(R.id.sugerenciaTextView).text = when (objetivo) {
            "subir" -> "Te sugerimos aumentar tu peso de manera saludable."
            "mantener" -> "Tu peso es adecuado. Te sugerimos mantenerlo."
            "bajar" -> "Te sugerimos bajar de peso de manera saludable."
            else -> "Consulta con un especialista para obtener recomendaciones personalizadas."
        }

        // Mostrar la clasificación del IMC
        val clasificacionTextView = findViewById<TextView>(R.id.clasificacionTextView)
        clasificacionTextView.text = "Clasificación: ${obtenerClasificacion(imc)}"

        // Botón de recalcular
        val recalcularButton = findViewById<Button>(R.id.recalcularButton)
        recalcularButton.setOnClickListener {
            // Volver a la SegundaPantallaActivity para modificar los datos
            val intent = Intent(this, SegundaPantallaActivity::class.java)
            intent.putExtra("nombre", nombre)
            intent.putExtra("genero", genero)
            intent.putExtra("fechaNacimiento", fechaNacimiento)
            intent.putExtra("peso", peso)
            intent.putExtra("estatura", estatura)

            startActivity(intent)
        }

        // Botón para ver la planificación
        val verPlanificacionButton = findViewById<Button>(R.id.verPlanificacionButton)
        verPlanificacionButton.setOnClickListener {
            // Ir a la PlanificacionActivity con los datos actuales
            val intent = Intent(this, PlanificacionActivity::class.java)
            intent.putExtra("nombre", nombre)
            intent.putExtra("genero", genero)
            intent.putExtra("fechaNacimiento", fechaNacimiento)
            intent.putExtra("peso", peso)
            intent.putExtra("estatura", estatura)
            intent.putExtra("imc", imc)
            intent.putExtra("OBJETIVO", objetivo)  // Pasar el IMC calculado a la planificación
            startActivity(intent)
        }
    }

    private fun obtenerSugerenciaObjetivo(imc: Float): String {
        return when {
            imc < 18.5 -> "subir"  // Bajo peso
            imc in 18.5..24.9 -> "mantener"  // Peso normal
            imc in 25.0..29.9 -> "bajar"  // Sobrepeso
            imc >= 30.0 -> "bajar"  // Obesidad
            else -> "mantener"
        }
    }

    private fun obtenerClasificacion(imc: Float): String {
        return when {
            imc < 18.5 -> "Bajo peso"
            imc in 18.5..24.9 -> "Normal"
            imc in 25.0..29.9 -> "Sobrepeso"
            imc >= 30.0 -> "Obesidad"
            else -> "Indeterminado"
        }
    }
}