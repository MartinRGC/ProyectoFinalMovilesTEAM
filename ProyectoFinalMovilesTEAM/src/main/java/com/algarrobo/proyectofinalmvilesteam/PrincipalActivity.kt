package com.algarrobo.proyectofinalmvilesteam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import com.algarrobo.proyectofinalmvilesteam.fragments.ListadoFragment

class PrincipalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)

        val btnResta: Button = findViewById(R.id.btnResta)

        btnResta.setOnClickListener{
            startActivity(Intent(this,ListadoFragment::class.java))
        }

    }
    fun usuario(view: View){
        startActivity(Intent(this,UserActivity::class.java))
    }
}