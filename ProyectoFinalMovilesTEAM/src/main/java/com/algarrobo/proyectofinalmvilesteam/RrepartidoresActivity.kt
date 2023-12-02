package com.algarrobo.proyectofinalmvilesteam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.algarrobo.proyectofinalmvilesteam.models.LRepartidorModel
import com.google.firebase.firestore.FirebaseFirestore

class RrepartidoresActivity : AppCompatActivity() {

    private val db = FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rrepartidores)

        val btnCance: Button = findViewById(R.id.btnRegister2)

        btnCance.setOnClickListener {
            startActivity(Intent(this, RepartidoresActivity::class.java))
        }

        val btnRegistrarRepartidor: Button = findViewById(R.id.btnRegister3)

        btnRegistrarRepartidor.setOnClickListener {
            // Obtener datos del layout (ajusta según tus vistas)
            val edtnombreReparti: EditText = findViewById(R.id.edtnombreReparti)
            val edtapellidoReparti: EditText = findViewById(R.id.edtapellidoReparti)
            val edtciudadReparti: EditText = findViewById(R.id.edtciudadReparti)
            val edttelefonoReparti: EditText = findViewById(R.id.edttelefonoReparti)
            val edtcorreoReparti: EditText = findViewById(R.id.edtcorreoReparti)

            val nombre = edtnombreReparti.text.toString()
            val apellido = edtapellidoReparti.text.toString()
            val ciudad = edtciudadReparti.text.toString()
            val telefono = edttelefonoReparti.text.toString()
            val correo = edtcorreoReparti.text.toString()

            // Crear un nuevo objeto LRepartidorModel
            val nuevoRepartidor = LRepartidorModel(
                nombre,
                apellido,
                ciudad,
                telefono,
                correo
            )

            // Registrar el nuevo repartidor en Firebase
            registrarRepartidorEnFirebase(nuevoRepartidor)

            limpiarEditTexts()
        }

    }

    private fun registrarRepartidorEnFirebase(repartidor: LRepartidorModel) {
        db.collection("repartidores")
            .add(repartidor)
            .addOnSuccessListener {
                Toast.makeText(this, "Repartidor registrado con éxito", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener { exception ->
                Log.e("RrepartidoresActivity", "Error al registrar repartidor", exception)
                Toast.makeText(this, "Error al registrar repartidor", Toast.LENGTH_SHORT).show()
            }
    }
    private fun limpiarEditTexts() {
        findViewById<EditText>(R.id.edtnombreReparti).text.clear()
        findViewById<EditText>(R.id.edtapellidoReparti).text.clear()
        findViewById<EditText>(R.id.edtciudadReparti).text.clear()
        findViewById<EditText>(R.id.edttelefonoReparti).text.clear()
        findViewById<EditText>(R.id.edtcorreoReparti).text.clear()
    }
}
