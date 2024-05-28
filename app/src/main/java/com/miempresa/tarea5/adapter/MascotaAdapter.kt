package com.miempresa.tarea5.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.miempresa.tarea5.R
import com.miempresa.tarea5.databinding.MascotaRowLayoutBinding
import com.miempresa.tarea5.model.Mascota
import com.miempresa.tarea5.model.Raza

class MascotaAdapter(private val mascotas: List<Mascota>) : RecyclerView.Adapter<MascotaAdapter.MascotaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MascotaViewHolder {
        val binding = MascotaRowLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MascotaViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MascotaViewHolder, position: Int) {
        val mascota = mascotas[position]
        holder.bind(mascota)
    }

    override fun getItemCount(): Int {
        return mascotas.size
    }

    class MascotaViewHolder(private val binding: MascotaRowLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(mascota: Mascota) {
            binding.imageView.setImageResource(getDrawableIdForRaza(mascota.raza))
            binding.textViewNombre.text = "Nombre: ${mascota.nombre}"
            binding.textViewDueno.text = "Dueño: ${mascota.dueno}"
        }

        private fun getDrawableIdForRaza(raza: Raza): Int {
            return when (raza) {
                Raza.PERRO -> R.drawable.perro
                Raza.GATO -> R.drawable.gato
                Raza.AVE -> R.drawable.ave
            }
        }
    }
}