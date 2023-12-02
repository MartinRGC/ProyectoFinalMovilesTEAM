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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repartidores)

        val recyclerView: RecyclerView = findViewById(R.id.rvRepartidoresAdmin)
        recyclerView.layoutManager = LinearLayoutManager(this)

        reparAdapter = RepartiAdapter(emptyList())
        recyclerView.adapter = reparAdapter

        // Obtener el restaurante seleccionado (puedes ajustar esto según cómo obtienes la información del restaurante)
        val restauranteElegido = obtenerRestauranteSeleccionado()

        // Realiza la consulta a Firebase para obtener los repartidores del restaurante seleccionado
        obtenerRepartiDesdeFirebase(restauranteElegido)

        val btnRegreRepar: Button = findViewById(R.id.btnRegReparti)

        btnRegreRepar.setOnClickListener {
            startActivity(Intent(this, Menu_principalActivity::class.java))
        }

        val btnNuevoRepar: Button = findViewById(R.id.btnnvrepartidor)

        btnNuevoRepar.setOnClickListener {
            startActivity(Intent(this, RrepartidoresActivity::class.java))
        }
    }

    private fun obtenerRepartiDesdeFirebase(restaurante: String) {
        db.collection("repartidores")
            .whereEqualTo("restaurante", restaurante)  // Filtra por el restaurante seleccionado
            .get()
            .addOnSuccessListener { result ->
                val repartList = mutableListOf<LRepartidorModel>()

                for (document in result) {
                    val repartidor = document.toObject(LRepartidorModel::class.java)
                    repartList.add(repartidor)
                }

                // Actualiza el Adapter con la nueva lista de repartidores
                reparAdapter.actualizarLista(repartList)
            }
            .addOnFailureListener { exception ->
                Log.e("RepartidoresActivity", "Error al obtener repartidores", exception)
            }
    }

    // Método ficticio para obtener el restaurante seleccionado (ajusta según tu implementación)
    private fun obtenerRestauranteSeleccionado(): String {
        // Por ejemplo, podrías obtener el restaurante desde un Intent o algún otro lugar
        return "McDonald's"  // Reemplaza esto con la lógica adecuada para obtener el restaurante seleccionado
        return "Bembos"
        return "Dominos"
    }
}
