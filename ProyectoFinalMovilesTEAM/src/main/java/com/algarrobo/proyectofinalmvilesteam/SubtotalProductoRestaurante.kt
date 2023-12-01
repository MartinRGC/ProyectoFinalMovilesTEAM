package com.algarrobo.proyectofinalmvilesteam

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.algarrobo.proyectofinalmvilesteam.models.ProductoRestauranteModel
import com.google.firebase.firestore.FirebaseFirestore
import com.squareup.picasso.Picasso

class SubtotalProductoRestaurante: AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_subtotalproductorestaurante)

            val restauranteProductoId = intent.getStringExtra("RESTAURANTEPRODUCTO_ID")

            // Dividir el ID combinado en IDs individuales del restaurante y del producto
            val ids = restauranteProductoId?.split("-")
            val restauranteId = ids?.get(0)
            val productoId = ids?.get(1)

            if (restauranteId != null && productoId != null) {
                // Aquí asumiendo que tienes una referencia a tu base de datos de Firestore
                val db = FirebaseFirestore.getInstance()
                val restauranteRef = db.collection("Restaurantes").document(restauranteId)
                val productoRef = restauranteRef.collection("Productos").document(productoId)

                // Obtener los detalles del producto usando productId
                productoRef.get()
                    .addOnSuccessListener { documentSnapshot ->
                        if (documentSnapshot.exists()) {
                            val producto = documentSnapshot.toObject(ProductoRestauranteModel::class.java)
                            // Aquí puedes acceder a los detalles del producto y actualizar tu UI
                            // Por ejemplo:
                            val nombreProducto = findViewById<TextView>(R.id.tvDetRestaurante2)
                            val precioProducto = findViewById<TextView>(R.id.tvPrecior2)
                            val ivImagen = findViewById<ImageView>(R.id.ivDetRestaurante2)

                            nombreProducto.text = producto?.descripcion
                            precioProducto.text= producto?.precio
                            Picasso.get().load(producto?.imageUrl).into(ivImagen)
                        } else {
                            // El documento no existe
                        }
                    }
                    .addOnFailureListener { exception ->
                        // Maneja la falla en la obtención de datos del producto
                    }
            } else {
                // El ID del restaurante o del producto no está disponible
            }
        }
}