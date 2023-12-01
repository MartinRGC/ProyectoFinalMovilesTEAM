package com.algarrobo.proyectofinalmvilesteam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class RrepartidoresActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rrepartidores)

        val btnCance: Button = findViewById(R.id.btnRegister2)

        btnCance.setOnClickListener {
            startActivity(Intent(this, RepartidoresActivity::class.java))
        }
    }
}