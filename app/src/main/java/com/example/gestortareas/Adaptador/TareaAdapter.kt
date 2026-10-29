package com.example.gestortareas.Adaptador

import androidx.recyclerview.widget.RecyclerView
import com.example.gestortareas.Model.Tarea
import com.example.gestortareas.databinding.ItemRecyclerviewBinding

class TareaAdapter(private var Tareas: List<Tarea>,
    private val onClick: (Tarea) -> Unit):
RecyclerView.Adapter<TareaAdapter.VH>(){
    class VH(val b: ItemRecyclerviewBinding) : RecyclerView.ViewHolder(b.root)
}