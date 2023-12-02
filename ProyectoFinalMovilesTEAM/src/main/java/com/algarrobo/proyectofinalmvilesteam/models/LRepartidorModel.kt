package com.algarrobo.proyectofinalmvilesteam.models

import java.io.Serializable

data class LRepartidorModel(
    val nombre: String = "",
    val restaurante: String = "",
    val apellido: String = "",
    val ciudad: String = "",
    val numero: String = "",
    val correo: String = ""
): Serializable
