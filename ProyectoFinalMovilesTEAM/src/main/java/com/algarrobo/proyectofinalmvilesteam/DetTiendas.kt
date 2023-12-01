package com.algarrobo.proyectofinalmvilesteam

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.algarrobo.proyectofinalmvilesteam.models.CTiendasModel
import com.algarrobo.proyectofinalmvilesteam.models.TiendasModel
import com.google.firebase.firestore.FirebaseFirestore
import com.squareup.picasso.Picasso

class DetTiendas: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dettienda)

        val  tiendaId = intent.getStringExtra("TIENDAS_ID") // Supongamos que pasaste el ID del restaurante desde la actividad anterior

        // Referencia a la base de datos de Firebase
        val db = FirebaseFirestore.getInstance()

        // Obtener referencia del restaurante específico
        val tiendaRef = db.collection("Tiendas").document(tiendaId.toString())

        // Obtener los datos del restaurante específico
        tiendaRef.get()
            .addOnSuccessListener { document ->
                if (document != null && document.exists()) {
                    val tiendaModel = document.toObject(TiendasModel::class.java)

                    // Mostrar los detalles del restaurante en los elementos de la interfaz de usuario
                    val tvNombre = findViewById<TextView>(R.id.tvDetTiendas)
                    val ivImagen = findViewById<ImageView>(R.id.ivDetTiendas)

                    tvNombre.text = tiendaModel?.Name
                    Picasso.get().load(tiendaModel?.IMAGE).into(ivImagen)
                } else {
                    Log.d("DetT", "No existe el documento")
                }
            }
            .addOnFailureListener { exception ->
                Log.d("DetT", "Error obteniendo el documento:", exception)
            }
    }
    }