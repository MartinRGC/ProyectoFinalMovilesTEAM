package com.algarrobo.proyectofinalmvilesteam

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.algarrobo.proyectofinalmvilesteam.fragments.adapter.MetodoPagoAdapter
import com.algarrobo.proyectofinalmvilesteam.models.MetodoPagosModel

import com.google.firebase.firestore.FirebaseFirestore

class MetodoDePagoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_metodopago)

        val rvListaMp = findViewById<RecyclerView>(R.id.rvListaMP)
        rvListaMp.layoutManager = LinearLayoutManager(this)

        val db = FirebaseFirestore.getInstance()

        db.collection("Pagos")
            .addSnapshotListener { snap, e ->
                if (e != null) {
                    Log.i("ERROR", "Ocurrió un error")
                    return@addSnapshotListener
                }

                val listaMetodosPagos = snap?.documents?.mapNotNull { document ->
                    MetodoPagosModel(
                        document.getString("CVC") ?: "",
                        document.getString("Fecha") ?: "",
                        document.getString("nombreM") ?: "",
                        document.getString("nombreT") ?: "",
                        document.getString("numero") ?: ""
                    )
                }

                // Asignar el adaptador al RecyclerView
                if (listaMetodosPagos != null) {
                    val adapter = MetodoPagoAdapter(listaMetodosPagos)
                    rvListaMp.adapter = adapter
                }
            }
    }

    fun agregar(view: View) {
        startActivity(Intent(this, NuevaTarjetaActivity::class.java))
    }
    fun pagar(view: View) {
        startActivity(Intent(this, PagoexitosoActivity::class.java))
    }
    }