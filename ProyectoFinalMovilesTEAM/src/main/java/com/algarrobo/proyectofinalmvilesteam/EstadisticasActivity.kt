package com.algarrobo.proyectofinalmvilesteam

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.algarrobo.proyectofinalmvilesteam.R.id.btnregresarse

class EstadisticasActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_estadisticas)

        val btnregresars: Button = findViewById(btnregresarse)

        btnregresars.setOnClickListener{
            startActivity(Intent(this, Menu_principalActivity::class.java))
        }
    }
}