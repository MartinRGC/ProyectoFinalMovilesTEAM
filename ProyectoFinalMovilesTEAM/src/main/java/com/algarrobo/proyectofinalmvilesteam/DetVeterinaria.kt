package com.algarrobo.proyectofinalmvilesteam

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.algarrobo.proyectofinalmvilesteam.models.TiendasModel

class DetVeterinaria: AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detvet)

        val tiendaDetalle = intent.getSerializableExtra("VETERINARIA_DETALLE") as TiendasModel
    }
}