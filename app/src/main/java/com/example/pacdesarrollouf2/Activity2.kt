package com.example.pacdesarrollouf2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_2.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.launch

class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this,"Entrando en Activity 2 (Datos)",Toast.LENGTH_SHORT).show()

        // Botones Menu

        buttonCrear.setOnClickListener{

            //Iniciamos hilo para crear tabla

            lifecycleScope.launch {
                val creardb = Room.databaseBuilder(applicationContext,LibroDB::class.java,"librodb").build()
                Toast.makeText(this@Activity2,"Tabla creada",Toast.LENGTH_SHORT).show()
            }
        }
        buttonIntroducir.setOnClickListener{
            val intent = Intent(this,InsertDatos::class.java)
            startActivity(intent)
        }
        buttonVisualizar.setOnClickListener{
            val intent = Intent(this,MostrarDatos::class.java)
            startActivity(intent)
        }
        buttonVolver.setOnClickListener{
            finish()
        }
    }
}
