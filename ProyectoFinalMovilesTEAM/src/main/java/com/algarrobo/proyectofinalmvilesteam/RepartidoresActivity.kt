package com.algarrobo.proyectofinalmvilesteam

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.algarrobo.proyectofinalmvilesteam.adapter.RepartiAdapter
import com.algarrobo.proyectofinalmvilesteam.adapter.RestAdapter
import com.algarrobo.proyectofinalmvilesteam.models.LRepartidorModel
import com.algarrobo.proyectofinalmvilesteam.models.LRestModel
import com.google.firebase.firestore.FirebaseFirestore

class RepartidoresActivity : AppCompatActivity() {
    private val db = FirebaseFirestore.getInstance()
    private lateinit var reparAdapter: RepartiAdapter
    @SuppressLint("WrongViewCast", "MissingInflatedId", "SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repartidores)

        val recyclerView: RecyclerView = findViewById(R.id.rvRepartidoresAdmin)
        recyclerView.layoutManager = LinearLayoutManager(this)

        reparAdapter = RepartiAdapter(emptyList()) // Inicializar con una lista vacía
        recyclerView.adapter = reparAdapter


        // Obtener datos desde Firebase y actualizar el adaptador
        obtenerRepartiDesdeFirebase { restaList ->
            reparAdapter.actualizarLista(restaList)
        }

        val btnRegreRepar: Button = findViewById(R.id.btnRegReparti)

        btnRegreRepar.setOnClickListener {
            startActivity(Intent(this, Menu_principalActivity::class.java))
        }
    }
    private fun obtenerRepartiDesdeFirebase(callback: (List<LRepartidorModel>) -> Unit) {
        db.collection("repartidores")
            .get()
            .addOnSuccessListener { result ->
                val repartList = result.map { document ->
                    document.toObject(LRepartidorModel::class.java)
                }
                callback(repartList)
            }
            .addOnFailureListener { exception ->
                // Manejar errores
                callback(emptyList())
            }
    }

}
