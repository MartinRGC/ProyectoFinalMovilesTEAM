package com.algarrobo.proyectofinalmvilesteam

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.algarrobo.proyectofinalmvilesteam.models.RestauranteModel


class DetRestaurante: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detrestaurante)

        val RestauranteDetalle = intent.getSerializableExtra("RESTAURANTE_DETALLE") as RestauranteModel
    }
}