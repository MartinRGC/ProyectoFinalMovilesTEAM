package com.algarrobo.proyectofinalmvilesteam

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.algarrobo.proyectofinalmvilesteam.fragments.adapter.VetAdapter
import com.algarrobo.proyectofinalmvilesteam.models.VeterinariaModel
import com.google.firebase.firestore.FirebaseFirestore

class ListadoVeterinariaActivity : AppCompatActivity(), VetAdapter.OnVeterinariaClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listadovet)

        val rvVeterinarias = findViewById<RecyclerView>(R.id.rvVeterinaria)
        rvVeterinarias.layoutManager = LinearLayoutManager(this)

        val db = FirebaseFirestore.getInstance()

        db.collection("Veterinarias")
            .addSnapshotListener { snap, e ->
                if (e != null) {
                    Log.i("ERROR", "Ocurrió un error")
                    return@addSnapshotListener
                }

                val listaVeterinarias = snap?.documents?.mapNotNull { document ->
                    VeterinariaModel(
                        document.getString("imageUrl") ?: "",
                        document.getString("nombre") ?: "",
                        document.getString("puntuacion") ?: "",
                        document.getString("tiempo") ?: ""
                    )
                }

                if (listaVeterinarias != null) {
                    val adaptador = VetAdapter(listaVeterinarias)
                    adaptador.setOnVeterinariaClickListener(this)
                    rvVeterinarias.adapter = adaptador
                }
            }
    }

    override fun onVeterinariaClick(veterinariaModel: VeterinariaModel) {
        val intent = Intent(this, DetVeterinaria::class.java)
        intent.putExtra("VETERINARIA_DETALLE", veterinariaModel)
        startActivity(intent)
    }
}