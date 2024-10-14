package com.example.proyect.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.proyect.R
import com.example.proyect.viewmodel.UsuarioViewModel

class PrimeraPantallaActivity : AppCompatActivity() {

    private lateinit var viewModel: UsuarioViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_primera_pantalla)

        viewModel = ViewModelProvider(this).get(UsuarioViewModel::class.java)

        val nombreInput = findViewById<EditText>(R.id.nombreInput)
        val generoRadioGroup = findViewById<RadioGroup>(R.id.generoRadioGroup)
        val fechaNacimientoPicker = findViewById<DatePicker>(R.id.fechaNacimientoPicker)
        val siguienteButton = findViewById<Button>(R.id.siguienteButton)

        siguienteButton.setOnClickListener {
            try {
                val nombre = nombreInput.text.toString().trim()
                if (nombre.isEmpty()) {
                    throw IllegalArgumentException("El nombre no puede estar vacío.")
                }

                val genero = when (generoRadioGroup.checkedRadioButtonId) {
                    R.id.radioHombre -> "Hombre"
                    R.id.radioMujer -> "Mujer"
                    else -> "Otro"
                }

                val fechaNacimiento = "${fechaNacimientoPicker.dayOfMonth}/${fechaNacimientoPicker.month + 1}/${fechaNacimientoPicker.year}"

                // Pasar los datos a la siguiente pantalla
                val intent = Intent(this, SegundaPantallaActivity::class.java)
                intent.putExtra("nombre", nombre)
                intent.putExtra("genero", genero)
                intent.putExtra("fechaNacimiento", fechaNacimiento)
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