package com.example.proyect

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class NotificationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)

        // Crear el canal de notificaciones
        crearCanalDeNotificacion()

        // Obtener el objetivo del usuario desde el intent
        val objetivo = intent.getStringExtra("objetivo") ?: "mantener"

        // Programar las alarmas para las comidas diarias según el objetivo
        programarAlarmasPorDiaYObjetivo(objetivo)
    }

    // Crear el canal de notificaciones
    private fun crearCanalDeNotificacion() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "Canal de Alimentación"
            val descriptionText = "Recordatorios para las comidas diarias"
            val importance = NotificationManager.IMPORTANCE_HIGH
            val channel = NotificationChannel("alimentacionChannel", name, importance).apply {
                description = descriptionText
            }
            val notificationManager: NotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    // Programar alarmas para cada día de la semana y objetivo
    private fun programarAlarmasPorDiaYObjetivo(objetivo: String) {
        val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val diasDeLaSemana = listOf("Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo")

        diasDeLaSemana.forEachIndexed { index, dia ->
            // Programar alarmas para desayuno, merienda, almuerzo y cena
            programarAlarmaDiaria("Desayuno $dia", "Es hora del desayuno ($dia). Objetivo: $objetivo", 8, 0, 1000 + index * 4 + 1, alarmManager, index)
            programarAlarmaDiaria("Merienda $dia", "Es hora de la merienda ($dia). Objetivo: $objetivo", 10, 30, 1000 + index * 4 + 2, alarmManager, index)
            programarAlarmaDiaria("Almuerzo $dia", "Es hora del almuerzo ($dia). Objetivo: $objetivo", 13, 0, 1000 + index * 4 + 3, alarmManager, index)
            programarAlarmaDiaria("Cena $dia", "Es hora de la cena ($dia). Objetivo: $objetivo", 19, 0, 1000 + index * 4 + 4, alarmManager, index)
        }
    }

    // Función para programar una alarma diaria
    private fun programarAlarmaDiaria(titulo: String, mensaje: String, hora: Int, minuto: Int, requestCode: Int, alarmManager: AlarmManager, diaDeLaSemana: Int) {
        val intent = Intent(this, AlarmaReceiver::class.java).apply {
            putExtra("titulo", titulo)
            putExtra("mensaje", mensaje)
        }

        val pendingIntent = PendingIntent.getBroadcast(this, requestCode, intent, PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE)

        val calendar = Calendar.getInstance().apply {
            timeInMillis = System.currentTimeMillis()
            set(Calendar.DAY_OF_WEEK, Calendar.MONDAY + diaDeLaSemana) // Configura el día de la semana
            set(Calendar.HOUR_OF_DAY, hora)
            set(Calendar.MINUTE, minuto)
            set(Calendar.SECOND, 0)
        }

        // Configura la alarma para repetirse cada semana
        alarmManager.setRepeating(
            AlarmManager.RTC_WAKEUP,
            calendar.timeInMillis,
            AlarmManager.INTERVAL_DAY * 7, // Repetir semanalmente
            pendingIntent
        )
    }
}