package com.algarrobo.proyectofinalmvilesteam

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.algarrobo.proyectofinalmvilesteam.fragments.adapter.TiendasAdapter
import com.algarrobo.proyectofinalmvilesteam.models.TiendasModel
import com.google.firebase.firestore.FirebaseFirestore

class ListadoTiendasActivity: AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listadotien)

        val rvTiend = findViewById<RecyclerView>(R.id.rvTiendas)

        val db = FirebaseFirestore.getInstance()
        var lstTiend: List<TiendasModel>

        db.collection("Tiendas")
            .addSnapshotListener{snap, e->
                if(e != null){
                    Log.i("ERROR", "Ocurrió un error")
                    return@addSnapshotListener
                }

                lstTiend = snap!!.documents.map { document ->
                    TiendasModel(
                        document["imageUrl"].toString(),
                        document["nombre"].toString()
                    )
                }

                rvTiend.adapter = TiendasAdapter(lstTiend)
                rvTiend.layoutManager = LinearLayoutManager(this)

            }
    }

}