package com.algarrobo.proyectofinalmvilesteam.models

import java.io.Serializable

data class LRestModel(
    val nombre: String = "",
    val tipo: String = "",
    val telefono: String = "",
    val horarioatencion: String = "",
    val ruc: String = ""
): Serializable
