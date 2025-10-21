package com.example.alumnorandom

data class Alumno (
    val nombre: String,
    val apellido: String,
    val seleccionado: Boolean = false,
)