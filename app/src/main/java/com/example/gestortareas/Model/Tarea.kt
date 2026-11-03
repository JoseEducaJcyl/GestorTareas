package com.example.gestortareas.Model

data class Tarea(
    var id: Int,
    var titulo: String,
    var descripcion: String = "",
    var prioridad: Prioridad = Prioridad.MEDIA,
    var estado: Estado = Estado.PENDIENTE
)