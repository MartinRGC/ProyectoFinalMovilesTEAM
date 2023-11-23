package com.algarrobo.proyectofinalmvilesteam

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.algarrobo.proyectofinalmvilesteam.adapter.TiendasAdapter
import com.algarrobo.proyectofinalmvilesteam.models.LTiendasModel
import com.google.firebase.firestore.FirebaseFirestore

class ListatiendasActivity : AppCompatActivity() {
    private val db = FirebaseFirestore.getInstance()
    private lateinit var tiendasAdapter: TiendasAdapter

    @SuppressLint("WrongViewCast", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listatiendas)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView3)
        recyclerView.layoutManager = LinearLayoutManager(this)

        tiendasAdapter = TiendasAdapter(emptyList()) // Inicializar con una lista vacía
        recyclerView.adapter = tiendasAdapter

        val btnListTiendas: Button = findViewById(R.id.btnlistiendas)

        btnListTiendas.setOnClickListener {
            // Obtener datos desde Firebase y actualizar el adaptador
            obtenerTiendasDesdeFirebase { tiendasList ->
                tiendasAdapter.actualizarLista(tiendasList)
            }
        }

        val btnRegresarDos: Button = findViewById(R.id.btnregresardos)

        btnRegresarDos.setOnClickListener {
            startActivity(Intent(this, Menu_principalActivity::class.java))
        }
    }

    private fun obtenerTiendasDesdeFirebase(callback: (List<LTiendasModel>) -> Unit) {
        db.collection("tiendas")
            .get()
            .addOnSuccessListener { result ->
                val tiendasList = result.map { document ->
                    document.toObject(LTiendasModel::class.java)
                }
                callback(tiendasList)
            }
            .addOnFailureListener { exception ->
                // Manejar errores
                callback(emptyList())
            }
    }
}