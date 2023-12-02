package com.algarrobo.proyectofinalmvilesteam.models

import java.io.Serializable

data class MetodoPagosModel(
    val CVC:String="",
    val Fecha:String="",
    val nombreM:String="",
    val nombreT:String="",
    val numero:String?="",

):Serializable