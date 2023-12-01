package com.algarrobo.proyectofinalmvilesteam.models

import java.io.Serializable

data class ProductoRestauranteModel(
    val imageUrl: String ="",
    val id:String="",
    val descripcion:String="",
    val precio:String="",

):Serializable
