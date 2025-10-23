package com.example.alumnorandom

data class Alumno (
    val nombre: String,
    val apellido: String,
    var seleccionado: Boolean = false,
    val alumosSeleccionados: List<Alumno>
){
    fun seleccionarAlumnos(){seleccionado = true}
}