package com.example.pacdesarrollouf2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_2.*
import kotlinx.android.synthetic.main.activity_2.buttonVolver
import kotlinx.android.synthetic.main.activity_3.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class Activity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_3)
        buttonStart.setOnClickListener{
            Intent(this,NoSeSiVivirOMorir::class.java).also{
                startService(intent)
            }
        }

        buttonVolver.setOnClickListener{
            finish()
        }
    }

    override fun onResume() {
        super.onResume()
        EventBus.getDefault().register(this)


    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEventBusEvent(res: String) {

    }
}