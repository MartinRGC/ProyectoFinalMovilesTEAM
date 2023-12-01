package com.algarrobo.proyectofinalmvilesteam

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.algarrobo.proyectofinalmvilesteam.fragments.adapter.CTiendaAdapter
import com.algarrobo.proyectofinalmvilesteam.models.CTiendasModel
import com.google.firebase.firestore.FirebaseFirestore


class ListadoTiendaCActivity : AppCompatActivity(), CTiendaAdapter.OnTiendaCClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listadotiendac)

        val rvTiendasC = findViewById<RecyclerView>(R.id.rvTiendasC)
        rvTiendasC.layoutManager = LinearLayoutManager(this)

        val db = FirebaseFirestore.getInstance()

        db.collection("TiendasC")
            .addSnapshotListener { snap, e ->
                if (e != null) {
                    Log.i("ERROR", "Ocurrió un error")
                    return@addSnapshotListener
                }

                val listaTiendasC = snap?.documents?.mapNotNull { document ->
                    CTiendasModel(
                        document.getString("imageUrl") ?: "",
                        document.getString("nombre") ?: "",
                        document.getString("puntuacion") ?: "",
                        document.getString("tiempo") ?: ""
                    )
                }

                if (listaTiendasC != null) {
                    val adaptador = CTiendaAdapter(listaTiendasC)
                    adaptador.setOnTiendaCClickListener(this)
                    rvTiendasC.adapter = adaptador
                }
            }
    }

    override fun onTiendaCClick(tiendaCModel: CTiendasModel) {
        val intent = Intent(this, DetTiendaC::class.java)
        intent.putExtra("TIENDAC_DETALLE", tiendaCModel)
        startActivity(intent)
    }
}