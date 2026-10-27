package com.javi.adivinarnumero

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Crear una variable con un número random del 1 al 100
        val numeroRandom = (1..100).random()
        // Crear una variable con el botón
        val boton = findViewById<Button>(R.id.button3)
        // Crear una variable con el texto
        val texto = findViewById<TextView>(R.id.textView)
        // Crear una variable con el editText
        val numeroIntroducido = findViewById<EditText>(R.id.editTextText3)
        //crear variable de numero de intentos
        var intentos = 0

        // Crear un evento click en el botón
        boton.setOnClickListener {
            // Crear una variable con el número introducido en el editText como Int
            val numero = numeroIntroducido.text.toString().toIntOrNull()
            if (numero == null || numero < 1 || numero > 100){
                numeroIntroducido.error = "Por favor, introduce un número entre 1 y 100"
            } else {
                intentos++
                // Comprobar el número con when
                when {
                    numero < numeroRandom -> texto.text = "El número es mayor"
                    numero > numeroRandom -> texto.text = "El número es menor"
                    else -> texto.text = "Enhorabuena, has acertado en el intento número $intentos"
                }

                //borrar el contenido del campo
                numeroIntroducido.text.clear()
                }
            }
        }
    }
