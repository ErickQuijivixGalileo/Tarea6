package com.miempresa.tarea5.model

data class Mascota(
    val id: Int,
    val nombre: String,
    val dueno: String,
    val raza: Raza
)

enum class Raza {
    PERRO,
    GATO,
    AVE
}

