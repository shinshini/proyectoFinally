package com.example.proyect

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

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
            val nombre = nombreInput.text.toString()
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
        }
    }
}