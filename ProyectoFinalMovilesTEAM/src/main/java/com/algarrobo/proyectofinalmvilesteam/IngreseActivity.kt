package com.algarrobo.proyectofinalmvilesteam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class IngreseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingrese)

        val btnContnr: Button = findViewById(R.id.btnContnr)

        btnContnr.setOnClickListener {

            startActivity(Intent(this, ContiniuActivity::class.java))
        }
    }
}