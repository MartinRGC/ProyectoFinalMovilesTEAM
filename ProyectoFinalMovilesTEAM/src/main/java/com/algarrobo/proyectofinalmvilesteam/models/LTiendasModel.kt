package com.algarrobo.proyectofinalmvilesteam.models

import java.io.Serializable

data class LTiendasModel(
    val nombre: String = "",
    val categoria: String = "",
    val telefono: String = "",
    val direccion: String = "",
    val horariodeatencion: String = ""
): Serializable
