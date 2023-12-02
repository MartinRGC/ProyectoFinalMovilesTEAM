package com.algarrobo.proyectofinalmvilesteam

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CalificaciónActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calificacion)

        val etPlocal = findViewById<EditText>(R.id.etPlocal)
        val etTP = findViewById<EditText>(R.id.etTP)
        val etPP = findViewById<EditText>(R.id.etPP)
        val etRP = findViewById<EditText>(R.id.etRP)
        val tvResultadoP = findViewById<TextView>(R.id.tvResultadoP)

        val editTextList = listOf(etPlocal, etTP, etPP, etRP)

        for (editText in editTextList) {
            editText.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    // Not needed for this implementation
                }

                override fun onTextChanged(
                    s: CharSequence?,
                    start: Int,
                    before: Int,
                    count: Int
                ) {
                    // Not needed for this implementation
                }

                override fun afterTextChanged(s: Editable?) {
                    calculateAndDisplayResult(
                        etPlocal.text.toString(),
                        etTP.text.toString(),
                        etPP.text.toString(),
                        etRP.text.toString(),
                        tvResultadoP
                    )
                }
            })
        }
    }

    private fun calculateAndDisplayResult(
        pLocal: String,
        tP: String,
        pP: String,
        rP: String,
        tvResultadoP: TextView
    ) {
        val pLocalValue = pLocal.toDoubleOrNull() ?: 0.0
        val tPValue = tP.toDoubleOrNull() ?: 0.0
        val pPValue = pP.toDoubleOrNull() ?: 0.0
        val rPValue = rP.toDoubleOrNull() ?: 0.0

        // Calcular la suma de los valores ingresados
        val suma = pLocalValue + tPValue + pPValue + rPValue

        // Calcular el promedio dividiendo la suma entre 4 (número de valores)
        val promedio = suma / 4

        // Mostrar el resultado en el TextView
        tvResultadoP.text = promedio.toString()
    }


    fun salir5(view: View){
        startActivity(Intent(this,PrincipalActivity::class.java))
    }

}


