package com.algarrobo.proyectofinalmvilesteam

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.algarrobo.proyectofinalmvilesteam.fragments.adapter.FarmaAdapter
import com.algarrobo.proyectofinalmvilesteam.models.FarmaModel
import com.google.firebase.firestore.FirebaseFirestore

class ListadoFarmActivity : AppCompatActivity(), FarmaAdapter.OnFarmaciaClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listadofarm)

        val rvFarmacias = findViewById<RecyclerView>(R.id.rvFarmacia)
        rvFarmacias.layoutManager = LinearLayoutManager(this)

        val db = FirebaseFirestore.getInstance()

        db.collection("Farmacias")
            .addSnapshotListener { snap, e ->
                if (e != null) {
                    Log.i("ERROR", "Ocurrió un error")
                    return@addSnapshotListener
                }

                val listaFarmacias = snap?.documents?.mapNotNull { document ->
                    FarmaModel(
                        document.getString("imageUrl") ?: "",
                        document.getString("nombre") ?: "",
                        document.getString("puntuacion") ?: "",
                        document.getString("tiempo") ?: "",
                        document.getString("id") ?: "",
                    )
                }

                if (listaFarmacias != null) {
                    val adaptador = FarmaAdapter(listaFarmacias)
                    adaptador.setOnFarmaciaClickListener(this)
                    rvFarmacias.adapter = adaptador
                }
            }
    }

    override fun onFarmaciaClick(IDF: String) {
        val intent = Intent(this, DetFarmacia::class.java)
        intent.putExtra("FARMACIA_ID", IDF)
        startActivity(intent)
    }
}