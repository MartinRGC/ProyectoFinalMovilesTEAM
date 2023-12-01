package com.algarrobo.proyectofinalmvilesteam

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.algarrobo.proyectofinalmvilesteam.models.FarmaModel
import com.google.firebase.firestore.FirebaseFirestore
import com.squareup.picasso.Picasso


class DetFarmacia: AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detfarm)

        val  farmaciaId = intent.getStringExtra("FARMACIA_ID") // Supongamos que pasaste el ID del restaurante desde la actividad anterior

        // Referencia a la base de datos de Firebase
        val db = FirebaseFirestore.getInstance()

        // Obtener referencia del restaurante específico
        val farmaciaRef = db.collection("Farmacias").document(farmaciaId.toString())

        // Obtener los datos del restaurante específico
        farmaciaRef.get()
            .addOnSuccessListener { document ->
                if (document != null && document.exists()) {
                    val farmaciaModel = document.toObject(FarmaModel::class.java)

                    // Mostrar los detalles del restaurante en los elementos de la interfaz de usuario
                    val tvNombre = findViewById<TextView>(R.id.tvDetFarmacia)
                    val ivImagen = findViewById<ImageView>(R.id.ivDetFarmacia)

                    tvNombre.text = farmaciaModel?.Name
                    Picasso.get().load(farmaciaModel?.IMAGE).into(ivImagen)
                } else {
                    Log.d("DetFarmacia", "No existe el documento")
                }
            }
            .addOnFailureListener { exception ->
                Log.d("DetFarmacia", "Error obteniendo el documento:", exception)
            }
    }
}