package com.example.pacdesarrollouf2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_2.buttonVolver
import kotlinx.android.synthetic.main.activity_3.*

class Activity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_3)
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