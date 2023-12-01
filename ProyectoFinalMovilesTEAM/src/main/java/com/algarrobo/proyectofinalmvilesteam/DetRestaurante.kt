package com.algarrobo.proyectofinalmvilesteam

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.algarrobo.proyectofinalmvilesteam.models.RestauranteModel
import com.google.firebase.firestore.FirebaseFirestore
import com.squareup.picasso.Picasso



class DetRestaurante : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detrestaurante)
        val restauranteId = intent.getStringExtra("RESTAURANTE_ID") // Supongamos que pasaste el ID del restaurante desde la actividad anterior

        // Referencia a la base de datos de Firebase
        val db = FirebaseFirestore.getInstance()

        // Obtener referencia del restaurante específico
        val restauranteRef = db.collection("Restaurantes").document(restauranteId.toString())

        // Obtener los datos del restaurante específico
        restauranteRef.get()
            .addOnSuccessListener { document ->
                if (document != null && document.exists()) {
                    val restauranteModel = document.toObject(RestauranteModel::class.java)

                    // Mostrar los detalles del restaurante en los elementos de la interfaz de usuario
                    val tvNombre = findViewById<TextView>(R.id.tvDetRestaurante)
                    val ivImagen = findViewById<ImageView>(R.id.ivDetRestaurante)

                    tvNombre.text = restauranteModel?.Name
                    Picasso.get().load(restauranteModel?.IMAGE).into(ivImagen)
                } else {
                    Log.d("DetRestaurante", "No existe el documento")
                }
            }
            .addOnFailureListener { exception ->
                Log.d("DetRestaurante", "Error obteniendo el documento:", exception)
            }
    }
}