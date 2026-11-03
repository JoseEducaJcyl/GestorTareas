package com.example.gestortareas

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gestortareas.Adaptador.TareaAdapter
import com.example.gestortareas.Model.Estado
import com.example.gestortareas.Model.Prioridad
import com.example.gestortareas.Model.Tarea
import com.example.gestortareas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    private lateinit var adapter_recicler: TareaAdapter
    private val tareas = mutableListOf<Tarea>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val prioridades = Prioridad.entries
        val spinnerAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            prioridades.map { it.etiqueta }
        )
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerPrioridad.adapter = spinnerAdapter

        tareas.add(Tarea(tareas.size+1,"Tarea${tareas.size+1}"))

        adapter_recicler = TareaAdapter(tareas) { tarea ->
            tarea.estado = tarea.estado.siguiente()
            adapter_recicler.notifyDataSetChanged()
        }

        binding.rvtareas.layoutManager = LinearLayoutManager(this)
        binding.rvtareas.adapter=adapter_recicler

        binding.buttonAniadirTarea.setOnClickListener {
            val titulo = binding.editTextTitulo.text.toString().trim()
            val descripcion = binding.editTextDescripcion.text.toString().trim()

            if (titulo.isEmpty()) {
                Toast.makeText(this, "El título no puede estar vacío", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val prioridadSeleccionada = prioridades[binding.spinnerPrioridad.selectedItemPosition]

            val nuevaTarea = Tarea(
                id = tareas.size + 1,
                titulo = titulo,
                descripcion = descripcion,
                prioridad = prioridadSeleccionada
            )

            tareas.add(nuevaTarea)
            adapter_recicler.notifyItemInserted(tareas.size - 1)
            binding.rvtareas.scrollToPosition(tareas.size - 1)

            binding.editTextTitulo.text?.clear()
            binding.editTextDescripcion.text?.clear()
            binding.spinnerPrioridad.setSelection(0)
        }
    }
}