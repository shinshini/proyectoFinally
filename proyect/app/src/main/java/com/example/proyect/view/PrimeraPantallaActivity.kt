package com.example.proyect.view

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.proyect.R
import com.example.proyect.viewmodel.UsuarioViewModel
import java.util.Calendar

class PrimeraPantallaActivity : AppCompatActivity() {

    private lateinit var viewModel: UsuarioViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_primera_pantalla)

        viewModel = ViewModelProvider(this).get(UsuarioViewModel::class.java)

        val nombreInput = findViewById<EditText>(R.id.nombreInput)
        val generoRadioGroup = findViewById<RadioGroup>(R.id.generoRadioGroup)
        val  fechaNacimientoInput= findViewById<AutoCompleteTextView>(R.id.fechaNacimientoInput)
        val siguienteButton = findViewById<Button>(R.id.siguienteButton)

        // Mostrar DatePicker al hacer clic en la entrada de la fecha de nacimiento
        fechaNacimientoInput.setOnClickListener {
            showDatePicker(fechaNacimientoInput)
        }

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

                // Validar la fecha de nacimiento
                val fechaNacimiento = fechaNacimientoInput.text.toString().trim()
                if (fechaNacimiento.isEmpty()) {
                    throw IllegalArgumentException("La fecha de nacimiento no puede estar vacía.")
                }

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
    // Método para mostrar el DatePicker cuando se haga clic en la entrada de la fecha de nacimiento
    private fun showDatePicker(fechaNacimientoInput: AutoCompleteTextView) {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { view, selectedYear, selectedMonth, selectedDay ->
                // Formatear la fecha seleccionada
                val formattedDate = "$selectedDay/${selectedMonth + 1}/$selectedYear"
                // Mostrar la fecha en el campo de texto
                fechaNacimientoInput.setText(formattedDate)
            },
            year, month, day
        )
        datePickerDialog.show()
    }
}