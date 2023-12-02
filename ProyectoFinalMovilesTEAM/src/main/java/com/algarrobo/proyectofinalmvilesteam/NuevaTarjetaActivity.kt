package com.algarrobo.proyectofinalmvilesteam

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore

class NuevaTarjetaActivity : AppCompatActivity() {

    private lateinit var cvcEditText: EditText
    private lateinit var fechaEditText: EditText
    private lateinit var nombreMEditText: EditText
    private lateinit var nombreTEditText: EditText
    private lateinit var numeroEditText: EditText

    private lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_newtarjeta)

        cvcEditText = findViewById(R.id.editTextCVC)
        fechaEditText = findViewById(R.id.editTextFecha)
        nombreMEditText = findViewById(R.id.editTextNombreM)
        nombreTEditText = findViewById(R.id.editTextNombreT)
        numeroEditText = findViewById(R.id.editTextNumero)

        db = FirebaseFirestore.getInstance()

        val guardarButton = findViewById<Button>(R.id.btnAgregar)
        guardarButton.setOnClickListener {
            guardarMetodoPago()
        }
    }

    private fun guardarMetodoPago() {
        val cvc = cvcEditText.text.toString()
        val fecha = fechaEditText.text.toString()
        val nombreM = nombreMEditText.text.toString()
        val nombreT = nombreTEditText.text.toString()
        val numero = numeroEditText.text.toString()

        val metodoPago = hashMapOf(
            "CVC" to cvc,
            "Fecha" to fecha,
            "nombreM" to nombreM,
            "nombreT" to nombreT,
            "numero" to numero
        )

        db.collection("Pagos")
            .add(metodoPago)
            .addOnSuccessListener { documentReference ->
                Toast.makeText(this, "Método de pago guardado con ID: ${documentReference.id}", Toast.LENGTH_SHORT).show()
                // Puedes hacer algo después de guardar, como regresar a la actividad anterior
                // finish()
            }
            .addOnFailureListener { e ->
                Toast.makeText(this, "Error al guardar el método de pago", Toast.LENGTH_SHORT).show()
                Log.w("AgregarMetodoPago", "Error al agregar el método de pago", e)
            }
    }
    fun regresar(view: View){
        startActivity(Intent(this,MetodoDePagoActivity::class.java))
    }
    fun pagar(view: View){
        startActivity(Intent(this,PagoexitosoActivity::class.java))
    }
}
