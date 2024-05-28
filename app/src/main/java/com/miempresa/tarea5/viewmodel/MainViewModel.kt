package com.miempresa.tarea5.viewmodel

import androidx.lifecycle.ViewModel
import com.miempresa.tarea5.model.Mascota

class MainViewModel : ViewModel() {
    val mascotas: MutableList<Mascota> = mutableListOf()

    fun agregarMascota(mascota: Mascota) {
        mascotas.add(mascota)
    }
}