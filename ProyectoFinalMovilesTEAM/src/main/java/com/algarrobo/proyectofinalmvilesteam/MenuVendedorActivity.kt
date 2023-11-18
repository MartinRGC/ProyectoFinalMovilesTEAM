package com.algarrobo.proyectofinalmvilesteam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.google.firebase.firestore.DocumentChange
import com.google.firebase.firestore.FirebaseFirestore
import com.squareup.picasso.Picasso

class MenuVendedorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_vendedor)
        val db = FirebaseFirestore.getInstance()
        val ivcomidav: ImageView = findViewById(R.id.ivcomidav)
        val menuvendcomida: TextView = findViewById(R.id.menuvendcomida)
        val preciomenucomvend: TextView = findViewById(R.id.preciomenucomvend)

        db.collection("Bembos")

            .addSnapshotListener{ snapshots, e->
                if (e != null){
                    Log.w("Firebase","listen:error", e)
                    return@addSnapshotListener
                }
                for (dc in snapshots!!.documentChanges){
                    when (dc.type){
                        DocumentChange.Type.ADDED ->{
                            Log.d("Firebase","Data: "+ dc.document.data)
                            val urlImagen = dc.document.data["url"].toString()
                            Picasso.get().load(urlImagen).into(ivcomidav)
                            menuvendcomida.text=dc.document.data["nombre"].toString()
                            preciomenucomvend.text=dc.document.data["Precio"].toString()
                        }
                        DocumentChange.Type.MODIFIED ->{
                            val urlImagen = dc.document.data["url"].toString()
                            Picasso.get().load(urlImagen).into(ivcomidav)
                            menuvendcomida.text=dc.document.data["nombre"].toString()
                            preciomenucomvend.text=dc.document.data["Precio"].toString()

                        }
                        DocumentChange.Type.REMOVED ->{
                            menuvendcomida.text = "Comida eliminada"
                            preciomenucomvend.text = "Precio eliminado"
                        }
                    }
                }

            }
    }
}