package com.algarrobo.proyectofinalmvilesteam

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.algarrobo.proyectofinalmvilesteam.models.TiendasModel

class DetTiendaC: AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dettiendac)

        val tiendaDetalle = intent.getSerializableExtra("TIENDAC_DETALLE") as TiendasModel
    }
}