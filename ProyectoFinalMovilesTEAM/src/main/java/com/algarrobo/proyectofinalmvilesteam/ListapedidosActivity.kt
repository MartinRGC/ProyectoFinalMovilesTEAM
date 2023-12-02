package com.algarrobo.proyectofinalmvilesteam

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ListapedidosActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listapedidos)

        val btnregresarss: Button = findViewById(R.id.btnregrresr)

        btnregresarss.setOnClickListener{
            startActivity(Intent(this, Menu_principalActivity::class.java))
        }
    }
}