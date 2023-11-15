package com.algarrobo.proyectofinalmvilesteam

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.algarrobo.proyectofinalmvilesteam.adapter.UserAdapter

class ListausuariosActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listausuarios)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val userList = listOf(
            UserData("John", "Doe", "john.doe@example.com", "1234567890", "123 Main St"),
            UserData("Pepa", "Smith", "jane.smith@example.com", "9876543210", "456 Oak St"),
            UserData("Janeth", "Vargas", "jane.vargas@example.com", "9876543210", "456 Oak St"),
            UserData("Julia", "Pacheco", "jl.pacheco@example.com", "9876543210", "456 Oak St"),
            UserData("Mario", "Perez", "m.perez@example.com", "9876543210", "456 Oak St"),
            UserData("Maya", "Rojas", "maya.rojas@example.com", "9876543210", "456 Oak St"),
            UserData("Rosario", "Montoya", "ros.mntya@example.com", "9876543210", "456 Oak St"),
            UserData("Pedro", "Reyes", "p.reyes@example.com", "9876543210", "456 Oak St"),
            UserData("Juan", "Osorio", "juan.osorio@example.com", "9876543210", "456 Oak St"),
            // Agrega más usuarios según sea necesario
        )

        val userAdapter = UserAdapter(userList)
        recyclerView.adapter = userAdapter

        val btnregre: Button = findViewById(R.id.btnregre)

       btnregre.setOnClickListener{
            startActivity(Intent(this, Menu_principalActivity::class.java))
       }

    }
}