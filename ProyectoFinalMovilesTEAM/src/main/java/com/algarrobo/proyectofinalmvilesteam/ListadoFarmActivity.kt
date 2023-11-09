package com.algarrobo.proyectofinalmvilesteam

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.algarrobo.proyectofinalmvilesteam.fragments.adapter.FarmaAdapter
import com.algarrobo.proyectofinalmvilesteam.fragments.adapter.RestauAdapter
import com.algarrobo.proyectofinalmvilesteam.models.FarmaModel
import com.algarrobo.proyectofinalmvilesteam.models.RestauranteModel
import com.google.firebase.firestore.FirebaseFirestore

class ListadoFarmActivity:AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listadofarm)

        val rvFarm = findViewById<RecyclerView>(R.id.rvFarmacia)

        val db = FirebaseFirestore.getInstance()
        var lstFarm: List<FarmaModel>

        db.collection("Farmacias")
            .addSnapshotListener{snap, e->
                if(e != null){
                    Log.i("ERROR", "Ocurrió un error")
                    return@addSnapshotListener
                }

                lstFarm = snap!!.documents.map { document ->
                    FarmaModel(
                        document["imageUrl"].toString(),
                        document["nombre"].toString()
                    )
                }

                rvFarm.adapter = FarmaAdapter(lstFarm)
                rvFarm.layoutManager = LinearLayoutManager(this)

            }
    }

    }