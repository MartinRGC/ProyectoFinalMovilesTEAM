package com.algarrobo.proyectofinalmvilesteam

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.algarrobo.proyectofinalmvilesteam.adapter.UserAdapter
import com.algarrobo.proyectofinalmvilesteam.models.UserModel
import com.google.firebase.firestore.FirebaseFirestore

class ListausuariosActivity : AppCompatActivity() {
    private val db = FirebaseFirestore.getInstance()
    private lateinit var userAdapter: UserAdapter

    @SuppressLint("WrongViewCast", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listausuarios)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        userAdapter = UserAdapter(emptyList()) // Inicializar con una lista vacía
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

    private fun obtenerUsuariosDesdeFirebase(callback: (List<UserModel>) -> Unit) {
        db.collection("usuarios")
            .get()
            .addOnSuccessListener { result ->
                val userList = result.map { document ->
                    document.toObject(UserModel::class.java)
                }
                callback(userList)
            }
            .addOnFailureListener { exception ->
                // Manejar errores
                callback(emptyList())
            }
    }
}

