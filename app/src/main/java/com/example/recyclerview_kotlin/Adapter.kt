package com.example.recyclerview_kotlin

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recyclerview_kotlin.databinding.ItemBinding


class Adapter: RecyclerView.Adapter<Adapter.ViewHolder>() {

    var pokemones = mutableListOf<Pokemon>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.ViewHolder {
        val binding = ItemBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: Adapter.ViewHolder, position: Int) {
        val pokemon = pokemones[position]
        holder.bind(pokemon)
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
            val color = Color.parseColor(getTypeColor(pokemon.tipo))
            binding.cardView.setCardBackgroundColor(color)
            Glide.with(itemView.context)
                .load(pokemon.imagen)
                .into(binding.imageViewPoke)
        }
    }
}

fun getTypeColor(type: String): String {
    return when(type.toLowerCase()) {
        "fire" -> "#FF4500"
        "water" -> "#0000FF"
        "grass" -> "#00FF00"
        "poison" -> "#8A2BE2"
        "normal" -> "#D3D3D3"
        "rock" -> "#8B4513"
        "electric" -> "#FFFF00"
        "fairy" -> "#FFB6C1"
        "fighting" -> "#B8860B"
        "bug" -> "#006400"
        "ghost" -> "#800080"
        "grass - poison" -> "#9ACD32"
        "fire - flying" -> "#FF8C00"
        "bug - flying" -> "#9ACD32"
        "bug - poison" -> "#9ACD32"


        // add more types as needed
        else -> "#FAF0E6" // a default color if no match found
    }
}