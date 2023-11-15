package com.algarrobo.proyectofinalmvilesteam

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class Menu_principalActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_principal)

        val button: Button = findViewById(R.id.btnmenuprincipal)
        button.setTextColor(ContextCompat.getColor(this, android.R.color.white))

        val listausuarios = findViewById<Button>(R.id.btnlistusuarios)
        val listarestaurantes = findViewById<Button>(R.id.btnlistrest)
        val listatiendas = findViewById<Button>(R.id.btnlisttiendas)
        val listapedidos = findViewById<Button>(R.id.btnlistpeddos)
        val listarepartidores = findViewById<Button>(R.id.btnlistrepar)
        val listaestadisticasgenerales = findViewById<Button>(R.id.btnlistestadg)

        listausuarios.setOnClickListener{
            startActivity(Intent(this, ListausuariosActivity::class.java))
        }





    }
}