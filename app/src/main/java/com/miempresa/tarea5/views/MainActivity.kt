package com.miempresa.tarea5.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.miempresa.tarea5.adapter.MascotaAdapter
import com.miempresa.tarea5.databinding.ActivityMainBinding
import com.miempresa.tarea5.model.Mascota
import com.miempresa.tarea5.model.Raza
import com.miempresa.tarea5.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: MascotaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = MainViewModel()

        adapter = MascotaAdapter(viewModel.mascotas)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        binding.buttonAgregar.setOnClickListener {
            val nombreMascota = binding.editTextNombre.text.toString()
            val duenoMascota = binding.editTextDueno.text.toString()
            val razaMascota = when (binding.spinnerRaza.selectedItemPosition) {
                0 -> Raza.PERRO
                1 -> Raza.GATO
                2 -> Raza.AVE
                else -> Raza.PERRO
            }
            val nuevaMascota = Mascota(viewModel.mascotas.size + 1, nombreMascota, duenoMascota, razaMascota)
            viewModel.agregarMascota(nuevaMascota)
            adapter.notifyDataSetChanged()


            binding.editTextNombre.text.clear()
            binding.editTextDueno.text.clear()
            binding.spinnerRaza.setSelection(0)
        }
    }
}