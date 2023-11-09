package com.algarrobo.proyectofinalmvilesteam

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.algarrobo.proyectofinalmvilesteam.fragments.adapter.VetAdapter
import com.algarrobo.proyectofinalmvilesteam.models.VeterinariaModel
import com.google.firebase.firestore.FirebaseFirestore

class ListadoVeterinariaActivity: AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listadovet)

        val rvVet = findViewById<RecyclerView>(R.id.rvVeterinaria)

        val db = FirebaseFirestore.getInstance()
        var lstVet: List<VeterinariaModel>

        db.collection("Veterinarias")
            .addSnapshotListener{snap, e->
                if(e != null){
                    Log.i("ERROR", "Ocurrió un error")
                    return@addSnapshotListener
                }

                lstVet = snap!!.documents.map { document ->
                    VeterinariaModel(
                        document["imageUrl"].toString(),
                        document["nombre"].toString()
                    )
                }

                rvVet.adapter = VetAdapter(lstVet)
                rvVet.layoutManager = LinearLayoutManager(this)

            }
    }

}