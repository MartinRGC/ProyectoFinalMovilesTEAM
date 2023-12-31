package com.algarrobo.proyectofinalmvilesteam

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView

class UserActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        val imagen: ImageView = findViewById(R.id.idHistorialPedido)

        imagen.setOnClickListener{startActivity(Intent(this,HistorialPedidosActivity::class.java))
        }
        val imagen1: ImageView = findViewById(R.id.imgAyuda)

        imagen1.setOnClickListener{startActivity(Intent(this,AyudaActivity::class.java))
        }
        val imagen2: ImageView = findViewById(R.id.idMetodoPago)

        imagen2.setOnClickListener{startActivity(Intent(this,MetodoDePagoActivity::class.java))
        }

    }
    fun MenuUsuario(view: View){
        startActivity(Intent(this,PrincipalActivity::class.java))
}
    fun salir4(view: View){
        startActivity(Intent(this,SplashActivity::class.java))
    }
    }