package com.algarrobo.proyectofinalmvilesteam

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.algarrobo.proyectofinalmvilesteam.models.VeterinariaModel
import com.google.firebase.firestore.FirebaseFirestore
import com.squareup.picasso.Picasso

class DetVeterinaria: AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detvet)

        val  veterinariaId = intent.getStringExtra("VETERINARIA_ID") // Supongamos que pasaste el ID del restaurante desde la actividad anterior

        // Referencia a la base de datos de Firebase
        val db = FirebaseFirestore.getInstance()

        // Obtener referencia del restaurante específico
        val veterinariaRef = db.collection("Veterinarias").document(veterinariaId.toString())

        // Obtener los datos del restaurante específico
        veterinariaRef.get()
            .addOnSuccessListener { document ->
                if (document != null && document.exists()) {
                    val veterinariaModel = document.toObject(VeterinariaModel::class.java)

                    // Mostrar los detalles del restaurante en los elementos de la interfaz de usuario
                    val tvNombre = findViewById<TextView>(R.id.tvDetVeterinaria)
                    val ivImagen = findViewById<ImageView>(R.id.ivDetVeterinaria)

                    tvNombre.text = veterinariaModel?.Name
                    Picasso.get().load(veterinariaModel?.IMAGE).into(ivImagen)
                } else {
                    Log.d("DetV", "No existe el documento")
                }
            }
            .addOnFailureListener { exception ->
                Log.d("DetV", "Error obteniendo el documento:", exception)
            }
    }
    }