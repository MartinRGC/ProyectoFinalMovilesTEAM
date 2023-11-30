package com.algarrobo.proyectofinalmvilesteam

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.algarrobo.proyectofinalmvilesteam.models.FarmaModel


class DetFarmacia: AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detfarm)

        val FarmaciaDetalle = intent.getSerializableExtra("FARMACIA_DETALLE") as FarmaModel
    }
}