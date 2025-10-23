package com.example.alumnorandom

data class Alumno (
    val nombre: String,
    val apellido: String,
    var seleccionado: Boolean = false,

){
    private val _alumnosSeleccionados = mutableListOf<Alumno>()
    val alumnosSeleccionados: List<Alumno> = _alumnosSeleccionados

    fun anyadirAlumnoSeleccionado(alumno: Alumno){
        _alumnosSeleccionados.add(alumno)
    }
    fun seleccionarAlumnos(){seleccionado = true}
}