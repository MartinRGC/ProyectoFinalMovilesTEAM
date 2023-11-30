package com.algarrobo.proyectofinalmvilesteam

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.algarrobo.proyectofinalmvilesteam.models.TiendasModel

class DetTiendas: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dettienda)

        val tiendaDetalle = intent.getSerializableExtra("TIENDA_DETALLE") as TiendasModel
}
}