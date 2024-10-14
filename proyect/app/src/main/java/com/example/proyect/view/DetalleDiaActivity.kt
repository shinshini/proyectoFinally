package com.example.proyect.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.proyect.R

class DetalleDiaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_dia)

        // Obtener el día y el objetivo del intent
        val dia = intent.getStringExtra("dia")
        val objetivo = intent.getStringExtra("objetivo")

        // Mostrar el día seleccionado
        findViewById<TextView>(R.id.diaTextView).text = "Planificación para $dia"

        // Obtener el plan del día según el objetivo
        val planDia = obtenerPlanDelDia(dia ?: "", objetivo ?: "")

        // Mostrar las comidas con sus recetas
        findViewById<TextView>(R.id.desayunoTextView).text = "Desayuno: ${planDia.desayuno}"
        findViewById<TextView>(R.id.desayunoRecetaTextView).text = "Receta: ${planDia.recetaDesayuno}"

        findViewById<TextView>(R.id.meriendaTextView).text = "Merienda: ${planDia.merienda}"
        findViewById<TextView>(R.id.meriendaRecetaTextView).text = "Receta: ${planDia.recetaMerienda}"

        findViewById<TextView>(R.id.almuerzoTextView).text = "Almuerzo: ${planDia.almuerzo}"
        findViewById<TextView>(R.id.almuerzoRecetaTextView).text = "Receta: ${planDia.recetaAlmuerzo}"

        findViewById<TextView>(R.id.cenaTextView).text = "Cena: ${planDia.cena}"
        findViewById<TextView>(R.id.cenaRecetaTextView).text = "Receta: ${planDia.recetaCena}"

        // Botón para volver a la planificación
        val volverButton = findViewById<Button>(R.id.volverAPlanificacionButton)
        volverButton.setOnClickListener {
            val intentPlanificacion = Intent(this, PlanificacionActivity::class.java)
            startActivity(intentPlanificacion)
            finish()
        }
    }

    private fun obtenerPlanDelDia(dia: String, objetivo: String): PlanDia {
        // Aquí puedes definir un plan por cada día para los tres objetivos (subir, bajar, mantener)
        return when (objetivo) {
            "subir" -> planSubirPeso(dia)
            "bajar" -> planBajarPeso(dia)
            "mantener" -> planMantenerPeso(dia)
            else -> PlanDia("No disponible", "No disponible", "No disponible", "No disponible", "No disponible", "No disponible", "No disponible", "No disponible")
        }
    }

    // Definir plan para cada día con recetas
    private fun planSubirPeso(dia: String): PlanDia {
        return when (dia) {
            "Lunes" -> PlanDia(
                "Huevos revueltos con aguacate y pan integral", "Receta: Bate 2 huevos, agrégalos a un sartén caliente con una cucharada de aceite de oliva, cocina hasta que estén cocidos. Sirve con aguacate y pan integral.",
                "Yogur con frutas y nueces", "Receta: Mezcla 1 taza de yogur natural con fresas y un puñado de nueces.",
                "Pollo a la plancha con arroz y vegetales", "Receta: Cocina 1 pechuga de pollo en un sartén con aceite de oliva. Acompaña con arroz integral y vegetales al vapor.",
                "Pescado al horno con ensalada", "Receta: Precalienta el horno a 180°C. Hornea un filete de pescado con hierbas y aceite de oliva por 20 minutos. Sirve con una ensalada de lechuga y tomate."
            )
            // Agregar el resto de los días
            else -> PlanDia("No disponible", "No disponible", "No disponible", "No disponible", "No disponible", "No disponible", "No disponible", "No disponible")
        }
    }
    // De la misma manera defines las recetas para bajar peso y mantener peso
    private fun planBajarPeso(dia: String): PlanDia {
        return when (dia) {
            "Lunes" -> PlanDia(
                "Huevos revueltos con aguacate y pan integral", "Receta: Bate 2 huevos, agrégalos a un sartén caliente con una cucharada de aceite de oliva, cocina hasta que estén cocidos. Sirve con aguacate y pan integral.",
                "Yogur con frutas y nueces", "Receta: Mezcla 1 taza de yogur natural con fresas y un puñado de nueces.",
                "Pollo a la plancha con arroz y vegetales", "Receta: Cocina 1 pechuga de pollo en un sartén con aceite de oliva. Acompaña con arroz integral y vegetales al vapor.",
                "Pescado al horno con ensalada", "Receta: Precalienta el horno a 180°C. Hornea un filete de pescado con hierbas y aceite de oliva por 20 minutos. Sirve con una ensalada de lechuga y tomate."
            )
            // Agregar el resto de los días
            else -> PlanDia("No disponible", "No disponible", "No disponible", "No disponible", "No disponible", "No disponible", "No disponible", "No disponible")
        }
    }
    private fun planMantenerPeso(dia: String): PlanDia {
        return when (dia) {
            "Lunes" -> PlanDia(
                "Huevos revueltos con aguacate y pan integral", "Receta: Bate 2 huevos, agrégalos a un sartén caliente con una cucharada de aceite de oliva, cocina hasta que estén cocidos. Sirve con aguacate y pan integral.",
                "Yogur con frutas y nueces", "Receta: Mezcla 1 taza de yogur natural con fresas y un puñado de nueces.",
                "Pollo a la plancha con arroz y vegetales", "Receta: Cocina 1 pechuga de pollo en un sartén con aceite de oliva. Acompaña con arroz integral y vegetales al vapor.",
                "Pescado al horno con ensalada", "Receta: Precalienta el horno a 180°C. Hornea un filete de pescado con hierbas y aceite de oliva por 20 minutos. Sirve con una ensalada de lechuga y tomate."
            )
            // Agregar el resto de los días
            else -> PlanDia("No disponible", "No disponible", "No disponible", "No disponible", "No disponible", "No disponible", "No disponible", "No disponible")
        }
    }
}

// Clase PlanDia para almacenar las comidas y recetas
data class PlanDia(
    val desayuno: String, val recetaDesayuno: String,
    val merienda: String, val recetaMerienda: String,
    val almuerzo: String, val recetaAlmuerzo: String,
    val cena: String, val recetaCena: String
)