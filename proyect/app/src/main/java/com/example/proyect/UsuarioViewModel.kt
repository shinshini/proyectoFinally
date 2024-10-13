package com.example.proyect

import android.app.Application
import android.content.ContentValues
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UsuarioViewModel(application: Application) : AndroidViewModel(application) {

    private val _usuario = MutableLiveData<Usuario>()
    val usuario: LiveData<Usuario> get() = _usuario
    val context = getApplication<Application>().applicationContext

    // Guardar usuario y almacenar en SQLite
    fun guardarUsuario(nombre: String, genero: String, fechaNacimiento: String, estatura: Float, peso: Float) {
        val usuario = Usuario(nombre, genero, fechaNacimiento, estatura, peso)
        _usuario.value = usuario
        guardarEnBaseDeDatos(usuario)
    }

    // Función para almacenar en SQLite
    private fun guardarEnBaseDeDatos(usuario: Usuario) {
        val db = SQLiteHelper.getInstance(context).writableDatabase
        val contentValues = ContentValues().apply {
            put("nombre", usuario.nombre)
            put("genero", usuario.genero)
            put("fechaNacimiento", usuario.fechaNacimiento)
            put("estatura", usuario.estatura)
            put("peso", usuario.peso)
        }
        db.insert("usuarios", null, contentValues)
        db.close()
    }

    // Calcular el IMC del usuario
    fun calcularIMC(peso: Float, estatura: Float): Float {
        return peso / (estatura * estatura)
    }

    // Obtener clasificación del IMC según tabla
    fun obtenerClasificacionIMC(imc: Float): String {
        return when {
            imc < 18.5 -> "Bajo peso"
            imc in 18.5..24.9 -> "Peso normal"
            imc in 25.0..29.9 -> "Sobrepeso"
            imc in 30.0..34.9 -> "Obesidad Grado I"
            imc in 35.0..39.9 -> "Obesidad Grado II"
            else -> "Obesidad Grado III"
        }
    }
}