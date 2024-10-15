package com.example.proyect.view

import android.content.Intent
import android.os.Bundle
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
        val objetivo = intent.getStringExtra("OBJETIVO")

        // Configurar los botones para cada día de la semana
        val diasSemana = listOf("Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo")

        val planificacionListView = findViewById<ListView>(R.id.planificacionListView)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, diasSemana)
        planificacionListView.adapter = adapter

        // Listener para cada día
        planificacionListView.setOnItemClickListener { _, _, position, _ ->
            val diaSeleccionado = diasSemana[position]

            // Abrir la actividad de detalles para el día seleccionado
            val intent = Intent(this, DetalleDiaActivity::class.java).apply {
                putExtra("DIA", diaSeleccionado) // Usar el día seleccionado
                putExtra("OBJETIVO", objetivo) // Pasar el objetivo
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
        intent.putExtra("objetivo", objetivo)
        startActivity(intent)
    }
}