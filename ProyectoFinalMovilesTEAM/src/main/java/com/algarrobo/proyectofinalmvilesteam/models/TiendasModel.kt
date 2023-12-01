package com.algarrobo.proyectofinalmvilesteam.models

import java.io.Serializable

data class TiendasModel(
    val imageUrl: String ="",
    val nombre: String="",
    val puntuacion:String="",
    val tiempo:String=""
): Serializable
