package com.algarrobo.proyectofinalmvilesteam

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.algarrobo.proyectofinalmvilesteam.models.ProductoRestauranteModel
import com.google.firebase.firestore.FirebaseFirestore
import com.squareup.picasso.Picasso

class SubtotalProductoRestaurante : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_subtotalproductorestaurante)

        val restauranteId = intent.getStringExtra("RESTAURANTE_ID")
        val productoId = intent.getStringExtra("PRODUCTO_ID")

        if (restauranteId != null && productoId != null) {
            val db = FirebaseFirestore.getInstance()
            val restauranteRef = db.collection("Restaurantes").document(restauranteId)
            val productoRef = restauranteRef.collection("Productos").document(productoId)
            productoRef.get()
                .addOnSuccessListener { documentSnapshot ->
                    if (documentSnapshot.exists()) {
                        val producto = documentSnapshot.toObject(ProductoRestauranteModel::class.java)
                        val nombreProducto = findViewById<TextView>(R.id.tvDetPeRestaurante)
                        val precioProducto = findViewById<TextView>(R.id.tvPrecior2)
                        val ivImagen = findViewById<ImageView>(R.id.ivDetPeRestaurante)

                        nombreProducto.text = producto?.descripcion
                        precioProducto.text = producto?.precio

                        val etCantidad = findViewById<EditText>(R.id.etCantidadR)
                        val tvTotal = findViewById<TextView>(R.id.tvTotalPR)

                        // Obtener el precio como Int
                        val precioString = producto?.precio
                        val precio = precioString?.toDoubleOrNull() ?: 0.0 // Si no se puede convertir, se usa 0 como valor predeterminado

                        // Listener para el cambio en el EditText
                        etCantidad.addTextChangedListener(object : TextWatcher {
                            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
                            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
                            override fun afterTextChanged(s: Editable?) {
                                val cantidadString = s.toString()
                                val cantidad = cantidadString.toIntOrNull() ?: 0 // Si no se puede convertir, se usa 0 como valor predeterminado
                                val total = precio * cantidad
                                tvTotal.text = total.toString()
                            }
                        })

                        Picasso.get().load(producto?.imageUrl).into(ivImagen)
                    } else {
                        // El documento no existe
                    }
                }
                .addOnFailureListener { exception ->
                    // Maneja la falla en la obtención de datos del producto
                }
        }
    }
    fun pago(view: View){
        startActivity(Intent(this,MetodoDePagoActivity::class.java))
    }
    }