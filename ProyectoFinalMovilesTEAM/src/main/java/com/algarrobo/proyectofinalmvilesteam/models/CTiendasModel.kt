package com.algarrobo.proyectofinalmvilesteam.models

import java.io.Serializable

data class CTiendasModel(
    val imageUrl: String ="",
    val nombre: String="",
    val puntuacion:String="",
    val tiempo:String=""
): Serializable
