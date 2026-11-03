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
    class VH(val layout: ItemRecyclerviewBinding) : RecyclerView.ViewHolder(layout.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        VH(ItemRecyclerviewBinding.inflate(LayoutInflater.from(parent.context),
            parent, false))

    override fun onBindViewHolder(holder: VH, position: Int) {
        val t = tareas[position]

        with(holder.layout) {
            tvTitulo.text = t.titulo
            tvPrioridad.text = t.prioridad.etiqueta
            tvPrioridad.setTextColor(
                ContextCompat.getColor(root.context, t.prioridad.colorRes)
            )
            tvEstado.text = t.estado.name
            root.setBackgroundColor(ContextCompat.getColor(root.context, t.prioridad.colorRes))
            root.setOnClickListener { onClick(t) }

        }
    }

    override fun getItemCount() = tareas.size

    fun actualizar(nuevas: List<Tarea>) {
        tareas = nuevas
        notifyDataSetChanged()
    }


}