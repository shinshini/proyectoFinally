package com.example.proyect.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.proyect.R
import com.example.proyect.viewmodel.UsuarioViewModel

class SegundaPantallaActivity : AppCompatActivity() {

    private lateinit var viewModel: UsuarioViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda_pantalla)

        viewModel = ViewModelProvider(this).get(UsuarioViewModel::class.java)

        val estaturaInput = findViewById<EditText>(R.id.estaturaInput)
        val pesoInput = findViewById<EditText>(R.id.pesoInput)
        val finalizarButton = findViewById<Button>(R.id.finalizarButton)

        // Obtener los valores pasados desde ResultadoActivity (si existen)
        val pesoActual = intent.getFloatExtra("peso", 0f)
        val estaturaActual = intent.getFloatExtra("estatura", 0f)

        // Prellenar los campos de texto con los valores recibidos
        if (pesoActual != 0f) {
            pesoInput.setText(pesoActual.toString())
        }
        if (estaturaActual != 0f) {
            estaturaInput.setText(estaturaActual.toString())
        }

        finalizarButton.setOnClickListener {
            try {
                // Obtener los datos esenciales que siempre deben estar disponibles
                val nombre = intent.getStringExtra("nombre") ?: throw IllegalArgumentException("Nombre no disponible")
                val genero = intent.getStringExtra("genero") ?: throw IllegalArgumentException("Género no disponible")
                val fechaNacimiento = intent.getStringExtra("fechaNacimiento") ?: throw IllegalArgumentException("Fecha de nacimiento no disponible")

                // Validar estatura
                val estaturaString = estaturaInput.text.toString()
                if (estaturaString.isEmpty()) {
                    throw IllegalArgumentException("La estatura no puede estar vacía.")
                }
                val estatura = estaturaString.toFloatOrNull() ?: throw IllegalArgumentException("La estatura debe ser un número válido.")

                // Validar peso
                val pesoString = pesoInput.text.toString()
                if (pesoString.isEmpty()) {
                    throw IllegalArgumentException("El peso no puede estar vacío.")
                }
                val peso = pesoString.toFloatOrNull() ?: throw IllegalArgumentException("El peso debe ser un número válido.")

                // Guardar el usuario en el ViewModel y Base de Datos
                viewModel.guardarUsuario(nombre, genero, fechaNacimiento, estatura, peso)

                // Ir a la pantalla de resultados con los datos nuevos
                val intent = Intent(this, ResultadoActivity::class.java)
                intent.putExtra("nombre", nombre)
                intent.putExtra("genero", genero)
                intent.putExtra("fechaNacimiento", fechaNacimiento)
                intent.putExtra("peso", peso)
                intent.putExtra("estatura", estatura)
                startActivity(intent)

            } catch (e: IllegalArgumentException) {
                // Mostrar un mensaje de error si los datos no son válidos
                Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
            } catch (e: Exception) {
                // Manejar cualquier otra excepción
                Toast.makeText(this, "Error inesperado: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}