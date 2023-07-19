package com.example.recyclerview_kotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview_kotlin.databinding.ItemBinding

/*
[x] Implementar clase Adapter
[x] Heredar RecuclerView
[x] Creaciones de métodos: onCreateViewHolder, onBindViewHolder y getItemCount
[x] Crear class ViewHolder
[x] Heredad RecyclerView.ViewHolder a class ViewHolder
[x] Agregar constructor
[x] Obtener datos

 */
class Adapter: RecyclerView.Adapter<Adapter.ViewHolder>() {

    var pokemones = mutableListOf<Pokemon>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.ViewHolder {
        val binding = ItemBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: Adapter.ViewHolder, position: Int) {
        var item = pokemones[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return pokemones.size

    }

    fun setData(pokedex: List<Pokemon>) {
        this.pokemones = pokedex.toMutableList()
    }

    class ViewHolder(private val binding: ItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(pokemon: Pokemon) {
            binding.textViewNombre.text = pokemon.nombre
            binding.textViewElemento.text = pokemon.tipo

        }
    }
}