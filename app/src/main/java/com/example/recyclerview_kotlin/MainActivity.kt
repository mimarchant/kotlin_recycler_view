package com.example.recyclerview_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.kotlinexamples.Pokedex
import com.example.recyclerview_kotlin.databinding.ActivityMainBinding

/* Pasos para crear recycleView
* 1.[x]Item layout
* 2.[x]layout con recyclerView
* 3.[x]Asignar layout manager
* 4.[]Adapter + ViewHolder
* 5.[x]Tener disponibles los datos
* */
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initAdapter()
    }

    private fun initAdapter() {
        val adapter = Adapter() //Adaptador
        val pokedex = Pokedex.getPokedex() //Lista, obteniendo informacion
        adapter.setData(pokedex) //Adapter con datos
        binding.recyclerView.adapter = adapter // Enlace de recycleview con adapter
    }
}