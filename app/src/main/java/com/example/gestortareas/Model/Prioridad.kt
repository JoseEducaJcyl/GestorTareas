package com.example.gestortareas.Model

import androidx.annotation.ColorRes
import com.example.gestortareas.R

enum class Prioridad(var etiqueta:String, @ColorRes var colorRes:Int) {
    BAJA("Baja",R.color.green),
    MEDIA("Media",R.color.orange),
    ALTA("Alta",R.color.red)
}