package com.example.pacdesarrollouf2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.vistalibros.view.*

class LibrosAdapter (private val contexto: Context,private val listalibros: List<Libro>) : ArrayAdapter<Libro> (contexto,0,listalibros){

    // Adaptador listview

    override fun getView(posicion: Int, convertView: View?, parent: ViewGroup): View {
        val layout = LayoutInflater.from(contexto).inflate(R.layout.vistalibros,parent,false)
        val libro = listalibros[posicion]
        layout.titulo.text = libro.titulo
        layout.iddb.text = libro.id.toString()
        layout.autor.text = libro.autor
        layout.edicion.text = libro.edicion.toString()
        return layout
    }

}

