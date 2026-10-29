package com.example.gestortareas.Adaptador

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.gestortareas.Model.Tarea
import com.example.gestortareas.databinding.ItemRecyclerviewBinding

class TareaAdapter(private var tareas: List<Tarea>,
    private val onClick: (Tarea) -> Unit):
RecyclerView.Adapter<TareaAdapter.VH>(){
    class VH(val b: ItemRecyclerviewBinding) : RecyclerView.ViewHolder(b.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        VH(ItemRecyclerviewBinding.inflate(LayoutInflater.from(parent.context),
            parent, false))

    override fun onBindViewHolder(holder: VH, position: Int) {
        val t = tareas[position]
        with(holder.b) {
            tvTitulo.text = t.titulo
            tvPrioridad.text = t.prioridad.etiqueta
            tvPrioridad.setTextColor(
                ContextCompat.getColor(root.context, t.prioridad.colorRes)
            )
            tvEstado.text = t.estado.etiqueta
            root.setOnClickListener { onClick(t) }
        }
    }

}