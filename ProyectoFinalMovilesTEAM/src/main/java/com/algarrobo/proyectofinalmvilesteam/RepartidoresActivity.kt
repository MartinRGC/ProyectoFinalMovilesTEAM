package com.algarrobo.proyectofinalmvilesteam

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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

        reparAdapter = RepartiAdapter(emptyList())
        recyclerView.adapter = reparAdapter

        // Obtener datos desde Firebase y actualizar el adaptador
        obtenerRepartiDesdeFirebase { repartList ->
            reparAdapter.actualizarLista(repartList)
        }

        val btnRegreRepar: Button = findViewById(R.id.btnRegReparti)

        btnRegreRepar.setOnClickListener {
            startActivity(Intent(this, Menu_principalActivity::class.java))
        }

        val btnNuevoRepar: Button = findViewById(R.id.btnnvrepartidor)

        btnNuevoRepar.setOnClickListener {
            startActivity(Intent(this, RrepartidoresActivity::class.java))
        }
    }
    private fun obtenerRepartiDesdeFirebase(callback: (List<LRepartidorModel>) -> Unit) {
        db.collection("repartidores")
            .get()
            .addOnSuccessListener { result ->
                val repartList = mutableListOf<LRepartidorModel>()

                for (document in result) {
                    val repartidor = document.toObject(LRepartidorModel::class.java)
                    repartList.add(repartidor)
                }

                callback(repartList)
            }
            .addOnFailureListener { exception ->
                Log.e("RepartidoresActivity", "Error al obtener repartidores", exception)
                callback(emptyList())
            }
    }
}