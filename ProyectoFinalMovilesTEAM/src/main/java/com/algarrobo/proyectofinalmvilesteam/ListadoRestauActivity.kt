package com.algarrobo.proyectofinalmvilesteam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.algarrobo.proyectofinalmvilesteam.fragments.adapter.RestauAdapter
import com.algarrobo.proyectofinalmvilesteam.models.RestauranteModel
import com.google.firebase.firestore.FirebaseFirestore

class ListadoRestauActivity: AppCompatActivity(), RestauAdapter.OnRestauranteClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listadorestau)
        val rvRestaurantes = findViewById<RecyclerView>(R.id.rvRestaurante)
        rvRestaurantes.layoutManager = LinearLayoutManager(this)

        val db = FirebaseFirestore.getInstance()

        db.collection("Restaurantes")
            .addSnapshotListener { snap, e ->
                if (e != null) {
                    Log.i("ERROR", "Ocurrió un error")
                    return@addSnapshotListener
                }

                val listaRestaurantes = snap?.documents?.mapNotNull { document ->
                    RestauranteModel(
                        document.getString("imageUrl") ?: "",
                        document.getString("nombre") ?: "",
                        document.getString("puntuacion") ?: "",
                        document.getString("tiempo") ?: "",
                        document.getString("idrestaurante") ?: "",
                    )
                }

                if (listaRestaurantes != null) {
                    val adaptador = RestauAdapter(listaRestaurantes)
                    adaptador.setOnRestauranteClickListener(this)
                    rvRestaurantes.adapter = adaptador
                }
            }
    }

    override fun onRestauranteClick(IDR:String) {
        val intent = Intent(this, DetRestaurante::class.java)
        intent.putExtra("RESTAURANTE_ID", IDR)
        startActivity(intent)
    }
}