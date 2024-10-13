package com.example.proyect

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
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
            val nombre = intent.getStringExtra("nombre")!!
            val genero = intent.getStringExtra("genero")!!
            val fechaNacimiento = intent.getStringExtra("fechaNacimiento")!!
            val estatura = estaturaInput.text.toString().toFloat()
            val peso = pesoInput.text.toString().toFloat()

            // Guardar el usuario en el ViewModel y Base de Datos
            viewModel.guardarUsuario(nombre, genero, fechaNacimiento, estatura, peso)

            // Ir a la pantalla de resultados
            val intent = Intent(this, ResultadoActivity::class.java)
            intent.putExtra("peso", peso)
            intent.putExtra("estatura", estatura)
            startActivity(intent)
        }
    }
}