package com.example.gestortareas

import android.os.Bundle
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

        tareas.add(Tarea(tareas.size+1,"Tarea${tareas.size+1}","", Prioridad.BAJA,
            Estado.EN_CURSO))

        adapter_recicler = TareaAdapter(tareas,{t -> t.estado = t.estado.siguiente()})
        binding.rvtareas.layoutManager = LinearLayoutManager(this)
        binding.rvtareas.adapter=adapter_recicler

    }
}