package com.javi.edad

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // incluimos las variables
        val edad = findViewById<EditText>(R.id.edad)
        val boton = findViewById<Button>(R.id.boton)
        val texto = findViewById<TextView>(R.id.text)
        val button7 = findViewById<Button>(R.id.button7)
        val button6 = findViewById<Button>(R.id.button6)

        findViewById<Button>(R.id.button7).setOnClickListener {
            if (edad.text.toString().toInt() == 0) {
                return@setOnClickListener
            }
            val edadInput = edad.text.toString()
            if (edadInput.isNotEmpty()) {
                edad.setText((edadInput.toInt() - 1).toString())
            }
            if (edad.text.toString().toInt() > 18) {
                texto.text = "Eres mayor de edad"
            } else {
                texto.text = "Eres menor de edad"
            }
        }
        findViewById<Button>(R.id.button6).setOnClickListener {
            val edadInput = edad.text.toString()
            if (edadInput.isNotEmpty())
            {
                edad.setText((edadInput.toInt() + 1).toString())
            }
            if (edad.text.toString().toInt() > 18) {
                texto.text = "Eres mayor de edad"
            } else {
                texto.text = "Eres menor de edad"
            }
        }

        findViewById<Button>(R.id.boton).setOnClickListener {
            val edadInput = edad.text.toString()
            if (edadInput.isNotEmpty()) {
                if (edadInput.toInt() >= 18) {
                    texto.text = "Eres mayor de edad"
                } else {
                    texto.text = "Eres menor de edad"
                }
            }
            }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}