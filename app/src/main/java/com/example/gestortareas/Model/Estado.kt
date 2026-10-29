package com.example.gestortareas.Model

enum class Estado {
    PENDIENTE,EN_CURSO,COMPLETADA;
    fun siguiente():Estado=
        when(this){
            PENDIENTE -> EN_CURSO
            EN_CURSO -> COMPLETADA
            COMPLETADA -> PENDIENTE
        }
}
