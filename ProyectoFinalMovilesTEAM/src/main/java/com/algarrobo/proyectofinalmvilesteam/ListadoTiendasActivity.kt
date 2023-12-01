package com.algarrobo.proyectofinalmvilesteam

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.algarrobo.proyectofinalmvilesteam.fragments.adapter.TiendasAdapter
import com.algarrobo.proyectofinalmvilesteam.models.TiendasModel
import com.google.firebase.firestore.FirebaseFirestore

class ListadoTiendasActivity : AppCompatActivity(), TiendasAdapter.OnTiendaClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listadotien)

        val rvTiend = findViewById<RecyclerView>(R.id.rvTiendas)

        val db = FirebaseFirestore.getInstance()
        var lstTiend: List<TiendasModel>

        db.collection("Tiendas")
            .addSnapshotListener { snap, e ->
                if (e != null) {
                    Log.i("ERROR", "Ocurrió un error")
                    return@addSnapshotListener
                }

                lstTiend = snap!!.documents.map { document ->
                    TiendasModel(
                        document.getString("imageUrl") ?: "",
                        document.getString("nombre") ?: "",
                        document.getString("puntuacion") ?: "",
                        document.getString("tiempo") ?: ""
                    )
                }

                val adapter = TiendasAdapter(lstTiend)
                adapter.setOnTiendaClickListener(this)
                rvTiend.adapter = adapter
                rvTiend.layoutManager = LinearLayoutManager(this)
            }
    }
    override fun onTiendaClick(tiendaModel: TiendasModel) {
        Log.d("CLICK", "Item clicked: ${tiendaModel.nombre}") // Agregar este Log para verificar si se activa al hacer clic
        val intent = Intent(this, DetTiendas::class.java)
        intent.putExtra("TIENDA_DETALLE", tiendaModel)
        startActivity(intent)
    }
}