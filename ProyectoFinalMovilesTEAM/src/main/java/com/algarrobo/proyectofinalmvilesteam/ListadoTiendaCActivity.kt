package com.algarrobo.proyectofinalmvilesteam

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.algarrobo.proyectofinalmvilesteam.fragments.adapter.CTiendaAdapter
import com.algarrobo.proyectofinalmvilesteam.models.CTiendasModel
import com.google.firebase.firestore.FirebaseFirestore

class ListadoTiendaCActivity: AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listadotiendac)

        val rvTiendC = findViewById<RecyclerView>(R.id.rvTiendasC)

        val db = FirebaseFirestore.getInstance()
        var lstTiendC: List<CTiendasModel>

        db.collection("TiendasC")
            .addSnapshotListener{snap, e->
                if(e != null){
                    Log.i("ERROR", "Ocurrió un error")
                    return@addSnapshotListener
                }

                lstTiendC = snap!!.documents.map { document ->
                    CTiendasModel(
                        document["imageUrl"].toString(),
                        document["nombre"].toString()
                    )
                }

                rvTiendC.adapter = CTiendaAdapter(lstTiendC)
                rvTiendC.layoutManager = LinearLayoutManager(this)

            }
    }

}