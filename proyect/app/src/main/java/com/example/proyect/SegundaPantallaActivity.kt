package com.example.proyect

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

class SegundaPantallaActivity : AppCompatActivity() {

    private lateinit var viewModel: UsuarioViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda_pantalla)

        viewModel = ViewModelProvider(this).get(UsuarioViewModel::class.java)

        val estaturaInput = findViewById<EditText>(R.id.estaturaInput)
        val pesoInput = findViewById<EditText>(R.id.pesoInput)
        val finalizarButton = findViewById<Button>(R.id.finalizarButton)

        finalizarButton.setOnClickListener {
            try {
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

                // Ir a la pantalla de resultados
                val intent = Intent(this, ResultadoActivity::class.java)
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