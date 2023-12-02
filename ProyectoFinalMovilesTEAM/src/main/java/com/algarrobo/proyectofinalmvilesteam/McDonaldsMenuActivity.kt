package com.algarrobo.proyectofinalmvilesteam

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.core.content.ContextCompat

class McDonaldsMenuActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mc_donalds_menu)

        Log.d("TAG", "McDonaldsMenuActivity onCreate")

    val button: Button = findViewById(R.id.btnMenuMC)
    button.setTextColor(ContextCompat.getColor(this, android.R.color.white))

    val listarestaurantes = findViewById<Button>(R.id.btnlistMC)
    val listapedidos = findViewById<Button>(R.id.btnPedidoMC)
    val listarepartidores = findViewById<Button>(R.id.btnReparMC)
        val listaestadisticasgenerales = findViewById<Button>(R.id.btnEstadMC)


    val btnfinalizar: Button = findViewById(R.id.btnFinaMC)

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