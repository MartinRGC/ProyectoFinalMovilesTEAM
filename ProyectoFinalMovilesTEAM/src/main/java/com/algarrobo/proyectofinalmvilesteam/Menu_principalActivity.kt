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

        val listarestaurantes = findViewById<Button>(R.id.btnlistrest)
        val listapedidos = findViewById<Button>(R.id.btnlistpeddos)
        val listarepartidores = findViewById<Button>(R.id.btnlistrepar)
        val listaestadisticasgenerales = findViewById<Button>(R.id.btnlistestadg)


        val btnfinalizar: Button = findViewById(R.id.btnfinalizar)

        btnfinalizar.setOnClickListener{
            startActivity(Intent(this, LoginActivity::class.java))
        }

        listarestaurantes.setOnClickListener{
            startActivity(Intent(this, ListaRestaurantesActivity::class.java))
        }
        listapedidos.setOnClickListener{
            startActivity(Intent(this, ListapedidosActivity::class.java))
        }
        listarepartidores.setOnClickListener{
            startActivity(Intent(this, RepartidoresActivity::class.java))
        }
        listaestadisticasgenerales.setOnClickListener{
            startActivity(Intent(this, EstadisticasActivity::class.java))
        }

    }
}