package com.example.proyect.utils

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import com.example.proyect.R
import com.example.proyect.view.PlanificacionActivity

class AlarmaReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        // Extraer el título y mensaje de la notificación desde el intent
        val titulo = intent.getStringExtra("Sweet Home") ?: "Recordatorio"
        val mensaje = intent.getStringExtra("Debes consumir a la hora tu alimento porfavor") ?: "Es hora de tu comida"

        // Crear un intent para abrir la actividad cuando se haga clic en la notificación
        val notificationIntent = Intent(context, PlanificacionActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(
            context, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        // Crear el objeto Notification
        val notification = NotificationCompat.Builder(context, "alimentacionChannel")
            .setSmallIcon(R.drawable.fondomain)  // Puedes personalizar este ícono
            .setContentTitle(titulo)
            .setContentText(mensaje)
            .setContentIntent(pendingIntent)  // Acción cuando el usuario toca la notificación
            .setAutoCancel(true)  // La notificación desaparece cuando el usuario la toca
            .build()

        // Obtener el NotificationManager
        val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        // Mostrar la notificación
        val notificationId = (System.currentTimeMillis() % 1000).toInt()  // Genera un ID único para cada notificación
        notificationManager.notify(notificationId, notification)  // Aquí se muestra la notificación
    }
}