package com.algarrobo.proyectofinalmvilesteam

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.algarrobo.proyectofinalmvilesteam.fragments.adapter.ProductoRAdapter
import com.algarrobo.proyectofinalmvilesteam.models.ProductoRestauranteModel
import com.algarrobo.proyectofinalmvilesteam.models.RestauranteModel
import com.google.firebase.firestore.FirebaseFirestore
import com.squareup.picasso.Picasso



class DetRestaurante : AppCompatActivity(), ProductoRAdapter.OnProductoRClickListener {

    private var restauranteId: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detrestaurante)


        restauranteId = intent.getStringExtra("RESTAURANTE_ID")

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

                    // Configurar RecyclerView para los productos
                    val rvProductos = findViewById<RecyclerView>(R.id.rvProductosR)
                    rvProductos.layoutManager = LinearLayoutManager(this)

                    // Obtener referencia a la colección de productos del restaurante
                    val productosRef = restauranteRef.collection("Productos")

                    // Obtener los productos del restaurante desde Firebase
                    productosRef.addSnapshotListener { snap, e ->
                        if (e != null) {
                            Log.i("ERROR", "Ocurrió un error")
                            return@addSnapshotListener
                        }

                        val listaProductos = snap?.documents?.mapNotNull { document ->
                            ProductoRestauranteModel(
                                document.getString("imageUrl") ?: "",
                                document.getString("id") ?: "",
                                document.getString("descripcion") ?: "",
                                document.getString("precio") ?: ""
                            )
                        }

                        if (listaProductos != null) {
                            val adaptador = ProductoRAdapter(listaProductos)
                            adaptador.setOnProductoRClickListener(this@DetRestaurante) // Usar this@DetRestaurante
                            rvProductos.adapter = adaptador
                        }
                    }
                } else {
                    Log.d("DetRestaurante", "No existe el documento")
                }
            }
            .addOnFailureListener { exception ->
                Log.d("DetRestaurante", "Error obteniendo el documento:", exception)
            }
    }

    override fun onProductoRClick(IDRP:String) {
        val intent = Intent(this, SubtotalProductoRestaurante::class.java)
        intent.putExtra("RESTAURANTE_ID",restauranteId )
        intent.putExtra("PRODUCTO_ID", IDRP)
        startActivity(intent)
    }
    }


