package com.algarrobo.proyectofinalmvilesteam

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.algarrobo.proyectofinalmvilesteam.fragments.adapter.ProductoRAdapter
import com.algarrobo.proyectofinalmvilesteam.models.ProductoRestauranteModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ListaRestaurantesActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var productoAdapter: ProductoRAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_restaurantes)

        recyclerView = findViewById(R.id.rvRestAdmins)
        recyclerView.layoutManager = LinearLayoutManager(this)
        productoAdapter = ProductoRAdapter(emptyList())
        recyclerView.adapter = productoAdapter

        // Leer los datos desde Firebase
        val databaseReference: DatabaseReference = FirebaseDatabase.getInstance().getReference("Productos")

        databaseReference.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val productos = mutableListOf<ProductoRestauranteModel>()

                for (snapshot in dataSnapshot.children) {
                    val producto = snapshot.getValue(ProductoRestauranteModel::class.java)
                    producto?.let {
                        productos.add(it)
                    }
                }

                // Actualizar el RecyclerView con la lista de productos
                actualizarRecyclerView(productos)
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Manejar errores, si es necesario
            }
        })
    }

    private fun actualizarRecyclerView(productos: List<ProductoRestauranteModel>) {
        productoAdapter.actualizarProductos(productos)
    }
}
