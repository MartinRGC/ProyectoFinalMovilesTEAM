package com.algarrobo.proyectofinalmvilesteam

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.algarrobo.proyectofinalmvilesteam.adapter.RestAdapter
import com.algarrobo.proyectofinalmvilesteam.adapter.TiendAdapter
import com.algarrobo.proyectofinalmvilesteam.fragments.adapter.RestauAdapter
import com.algarrobo.proyectofinalmvilesteam.models.LRestModel
import com.algarrobo.proyectofinalmvilesteam.models.LTiendasModel
import com.google.firebase.firestore.FirebaseFirestore

class ListaRestaurantesActivity : AppCompatActivity() {
    private val db = FirebaseFirestore.getInstance()
    private lateinit var restaAdapter: RestAdapter
    @SuppressLint("WrongViewCast", "MissingInflatedId", "SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_restaurantes)

        val recyclerView: RecyclerView = findViewById(R.id.rvRestAdmins)
        recyclerView.layoutManager = LinearLayoutManager(this)

        restaAdapter = RestAdapter(emptyList()) // Inicializar con una lista vacía
        recyclerView.adapter = restaAdapter


            // Obtener datos desde Firebase y actualizar el adaptador
            obtenerRestauDesdeFirebase { restaList ->
                restaAdapter.actualizarLista(restaList)
            }

        val btnRegre: Button = findViewById(R.id.btnRegresRest)

        btnRegre.setOnClickListener {
            startActivity(Intent(this, Menu_principalActivity::class.java))
        }
    }
    private fun obtenerRestauDesdeFirebase(callback: (List<LRestModel>) -> Unit) {
        db.collection("restaurantes")
            .get()
            .addOnSuccessListener { result ->
                val restList = result.map { document ->
                    document.toObject(LRestModel::class.java)
                }
                callback(restList)
            }
            .addOnFailureListener { exception ->
                // Manejar errores
                callback(emptyList())
            }
    }
}