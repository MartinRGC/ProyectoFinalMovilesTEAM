package com.algarrobo.proyectofinalmvilesteam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.algarrobo.proyectofinalmvilesteam.fragments.adapter.RestauAdapter
import com.algarrobo.proyectofinalmvilesteam.models.RestauranteModel
import com.google.firebase.firestore.FirebaseFirestore

class ListadoRestauActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listadorestau)

        val rvRstaur = findViewById<RecyclerView>(R.id.rvRestaurante)

        val db = FirebaseFirestore.getInstance()
        var lstRestau: List<RestauranteModel>

        db.collection("Restaurantes")
            .addSnapshotListener{snap, e->
            if(e != null){
                Log.i("ERROR", "Ocurrió un error")
                return@addSnapshotListener
            }

                lstRestau = snap!!.documents.map { document ->
                    RestauranteModel(
                        document["imageUrl"].toString(),
                        document["nombre"].toString()
                    )
                }

                rvRstaur.adapter = RestauAdapter(lstRestau)
                rvRstaur.layoutManager = LinearLayoutManager(this)

            }
    }
}
