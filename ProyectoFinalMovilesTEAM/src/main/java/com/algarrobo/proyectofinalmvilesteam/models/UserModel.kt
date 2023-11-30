package com.algarrobo.proyectofinalmvilesteam.models

import java.io.Serializable

data class UserModel(
    val nombre: String="",
    val apellidos: String="",
    val correo: String="",
    val celular: String="",
    val direccion: String=""
): Serializable
