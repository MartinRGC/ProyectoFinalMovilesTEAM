package com.algarrobo.proyectofinalmvilesteam

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.algarrobo.proyectofinalmvilesteam.adapter.UserAdapter
import com.google.firebase.firestore.FirebaseFirestore

class ListausuariosActivity : AppCompatActivity() {
    private val db = FirebaseFirestore.getInstance()
    @SuppressLint("WrongViewCast", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listausuarios)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val userAdapter = UserAdapter(emptyList()) // Inicializar con una lista vacía
        recyclerView.adapter = userAdapter


        val btnregre: Button = findViewById(R.id.btnregre)

       btnregre.setOnClickListener{
            startActivity(Intent(this, Menu_principalActivity::class.java))
       }

        // Obtener datos desde Firebase y actualizar el adaptador
        obtenerUsuariosDesdeFirebase { userList ->
            userAdapter.actualizarLista(userList)
        }


    }
    private fun obtenerUsuariosDesdeFirebase(callback: (List<UserData>) -> Unit) {
        db.collection("usuarios")
            .get()
            .addOnSuccessListener { result ->
                val userList = result.map { document ->
                    document.toObject(UserData::class.java)
                }
                callback(userList)
            }
            .addOnFailureListener { exception ->
                // Manejar errores
                callback(emptyList())
            }
        }
    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
