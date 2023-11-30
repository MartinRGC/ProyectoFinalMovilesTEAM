package com.algarrobo.proyectofinalmvilesteam.models

import java.io.Serializable

data class CustomerModel (
    val user: String ="",
    val password: String="",
    val phone: String="",
    val dateofbirth: String="",
    val email: String="",
    val UID: String= ""


): Serializable