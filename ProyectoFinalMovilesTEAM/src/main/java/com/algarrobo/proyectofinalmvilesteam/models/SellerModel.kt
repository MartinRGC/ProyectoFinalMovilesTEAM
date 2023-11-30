package com.algarrobo.proyectofinalmvilesteam.models

import java.io.Serializable

data class SellerModel (
    val ruc: String ="",
    val contraseña: String="",
    val celular: String="",
    val fechanacimiento: String="",
    val email: String="",
    val UID: String= ""
): Serializable