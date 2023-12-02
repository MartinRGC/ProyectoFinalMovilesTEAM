package com.algarrobo.proyectofinalmvilesteam.models

import java.io.Serializable

data class LRestModel(
    val descripcion: String = "",
    val imageUrl: String = "",
    val precio: String = ""
): Serializable
