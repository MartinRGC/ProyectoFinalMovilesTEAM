package com.algarrobo.proyectofinalmvilesteam

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.algarrobo.proyectofinalmvilesteam.models.CTiendasModel
import com.algarrobo.proyectofinalmvilesteam.models.FarmaModel
import com.algarrobo.proyectofinalmvilesteam.models.TiendasModel
import com.google.firebase.firestore.FirebaseFirestore
import com.squareup.picasso.Picasso

class DetTiendaC: AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dettiendac)

        val  tiendaCId = intent.getStringExtra("TIENDAC_ID") // Supongamos que pasaste el ID del restaurante desde la actividad anterior

        // Referencia a la base de datos de Firebase
        val db = FirebaseFirestore.getInstance()

        // Obtener referencia del restaurante específico
        val tiendaCRef = db.collection("TiendasC").document(tiendaCId.toString())

        // Obtener los datos del restaurante específico
        tiendaCRef.get()
            .addOnSuccessListener { document ->
                if (document != null && document.exists()) {
                    val tiendaCModel = document.toObject(CTiendasModel::class.java)

                    // Mostrar los detalles del restaurante en los elementos de la interfaz de usuario
                    val tvNombre = findViewById<TextView>(R.id.tvDetTiendaC)
                    val ivImagen = findViewById<ImageView>(R.id.ivDetTiendaC)

                    tvNombre.text = tiendaCModel?.Name
                    Picasso.get().load(tiendaCModel?.IMAGE).into(ivImagen)
                } else {
                    Log.d("DetTC", "No existe el documento")
                }
            }
            .addOnFailureListener { exception ->
                Log.d("DetTC", "Error obteniendo el documento:", exception)
            }
    }
}