package com.example.proyect

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat

class AlarmaReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        // Obtén el título y el mensaje de la notificación
        val titulo = intent.getStringExtra("titulo") ?: "Recordatorio"
        val mensaje = intent.getStringExtra("mensaje") ?: "Es hora de tu comida."

        // Crear la notificación
        val notification = NotificationCompat.Builder(context, "alimentacionChannel")
            .setSmallIcon(R.drawable.logounop) // Cambia esto por tu ícono
            .setContentTitle(titulo)
            .setContentText(mensaje)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setAutoCancel(true)
            .build()

        // Obtener el NotificationManager
        val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        // Mostrar la notificación
        notificationManager.notify((System.currentTimeMillis() % 1000).toInt(), notification)
    }
}