package com.algarrobo.proyectofinalmvilesteam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class PrincipalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)

    }
    fun usuario(view: View){
        startActivity(Intent(this,UserActivity::class.java))
    }

    fun restaurante(view: View){
        startActivity(Intent(this,ListadoRestauActivity::class.java))
    }
    fun farmacia(view: View){
        startActivity(Intent(this,ListadoFarmActivity::class.java))
    }
    fun Tiendas(view: View){
        startActivity(Intent(this,ListadoTiendasActivity::class.java))
    }
    fun TiendasC(view: View){
        startActivity(Intent(this,ListadoTiendaCActivity::class.java))
    }
    fun Veterinaria(view: View){
        startActivity(Intent(this,ListadoVeterinariaActivity::class.java))
    }
}