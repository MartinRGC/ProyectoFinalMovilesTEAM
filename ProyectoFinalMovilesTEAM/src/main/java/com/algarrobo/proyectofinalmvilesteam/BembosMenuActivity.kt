package com.algarrobo.proyectofinalmvilesteam

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.core.content.ContextCompat

class BembosMenuActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bembos_menu)

            Log.d("TAG", "BembosMenuActivity onCreate")

            val button: Button = findViewById(R.id.btnbbmenuprincipal)
            button.setTextColor(ContextCompat.getColor(this, android.R.color.white))

            val listarestaurantes = findViewById<Button>(R.id.btnlistrestBB)
            val listapedidos = findViewById<Button>(R.id.btnlistpeddosBB)
            val listarepartidores = findViewById<Button>(R.id.btnlistreparBB)
            val listaestadisticasgenerales = findViewById<Button>(R.id.btnestadisBB)


            val btnfinalizar: Button = findViewById(R.id.btnfinalizarDOM)

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