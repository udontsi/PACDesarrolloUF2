package com.example.pacdesarrollouf2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_mostrar_datos.*
import kotlinx.coroutines.launch

class MostrarDatos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mostrar_datos)
        var listaAdapter:ArrayAdapter<Libro>
        var libros = ArrayList<Libro>()
        lifecycleScope.launch {
            val creardb = Room.databaseBuilder(applicationContext, LibroDB::class.java, "librodb").build()
            libros = creardb.libroDao().verLibros() as ArrayList<Libro>
            listaAdapter = LibrosAdapter(applicationContext,libros)
            lvMostrar.adapter = listaAdapter
        }

    }
    override fun onResume() {
        super.onResume()

        buttonVolver.setOnClickListener {
            finish()
        }
    }
}