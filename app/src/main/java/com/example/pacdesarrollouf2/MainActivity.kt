package com.example.pacdesarrollouf2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    override fun onResume() {
        super.onResume()

        // Botones menu

        button.setOnClickListener{
            val intent = Intent(this,Activity2::class.java)
            startActivity(intent)
        }
        button2.setOnClickListener{
            val intent = Intent(this,Activity3::class.java)
            startActivity(intent)
        }
    }
}

