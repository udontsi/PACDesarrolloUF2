package com.example.pacdesarrollouf2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_2.buttonVolver
import kotlinx.android.synthetic.main.activity_3.*

class Activity3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_3)
    }
        override fun onResume() {
            super.onResume()

            // Configuramos spinner

            val options = mutableListOf<String>("Elegir...", "Reproducir", "Detener", "Bloquear")
            val option = findViewById(R.id.spinner) as Spinner
            option.adapter =ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options)
            option.onItemSelectedListener=object:AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedItem = parent?.getItemAtPosition(position).toString()
                if(selectedItem.equals("Reproducir")){
                    NoSeSiVivirOMorir.reproducir()
                }
                if(selectedItem.equals("Detener")){
                    NoSeSiVivirOMorir.pausa()
                }
                if(selectedItem.equals("Bloquear")){
                    NoSeSiVivirOMorir.bloquear()
                }

            }
        }

        // Botones menu

        buttonStart.setOnClickListener{
            NoSeSiVivirOMorir.startService(this)
        }
        buttonStop.setOnClickListener{
            NoSeSiVivirOMorir.stopService(this)
        }
        buttonVolver.setOnClickListener{
            finish()
        }
    }
}

