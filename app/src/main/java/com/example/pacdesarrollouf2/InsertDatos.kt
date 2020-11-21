package com.example.pacdesarrollouf2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_2.*
import kotlinx.android.synthetic.main.activity_2.buttonVolver
import kotlinx.android.synthetic.main.activity_insert_datos.*
import kotlinx.coroutines.launch

class InsertDatos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert_datos)
    }
    override fun onResume(){
        super.onResume()
        buttonGuardar.setOnClickListener{
            lifecycleScope.launch {
                val creardb = Room.databaseBuilder(applicationContext,LibroDB::class.java,"librodb").build()
                creardb.libroDao().insertLibro(libro = Libro(0,textTitulo.text.toString(),textAutor.text.toString(),textEdicion.text.toString().toInt()))
                Toast.makeText(this@InsertDatos,"Datos guardados", Toast.LENGTH_SHORT).show()
            }
            finish()
        }
        buttonVolver.setOnClickListener{
            finish()
        }
    }
}