package com.example.proyect.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.proyect.R

class PlanificacionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_planificacion)

        // Obtener el objetivo del intent
        val objetivo = intent.getStringExtra("OBJETIVO")?:"mantener"
        Log.d("PlanificacionActivity", "Objetivo recibido en PlanificacionActivity: $objetivo")
        // Configurar los botones para cada día de la semana
        val diasSemana = listOf("Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo")

        val planificacionListView = findViewById<ListView>(R.id.planificacionListView)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, diasSemana)
        planificacionListView.adapter = adapter

        // Listener para cada día
        planificacionListView.setOnItemClickListener { _, _, position, _ ->
            val diaSeleccionado = diasSemana[position]

            val intent = Intent(this, DetalleDiaActivity::class.java).apply {
                putExtra("DIA", diaSeleccionado)
                putExtra("OBJETIVO", objetivo)
                Log.d("PlanificacionActivity", "Objetivo enviado a DetalleDiaActivity: $objetivo")// El objetivo debe pasarse correctamente aquí
            }

            startActivity(intent)
        }
        // Botón para activar notificaciones
        val btnNotificaciones = findViewById<Button>(R.id.btnNotificaciones)
        btnNotificaciones.setOnClickListener {
            iniciarNotificaciones(objetivo ?: "mantener")
        }
    }

    // Función para iniciar las notificaciones
    private fun iniciarNotificaciones(objetivo: String) {
        val intent = Intent(this, NotificationActivity::class.java)
        intent.putExtra("OBJETIVO", objetivo)
        startActivity(intent)
    }
}