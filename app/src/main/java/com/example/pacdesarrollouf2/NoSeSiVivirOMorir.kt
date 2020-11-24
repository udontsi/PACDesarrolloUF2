package com.example.pacdesarrollouf2

import android.app.*
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.Build
import android.os.IBinder
import android.os.SystemClock.sleep
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import kotlin.concurrent.thread

class NoSeSiVivirOMorir : Service(){

    // Servicio

    companion object {
        var mp : MediaPlayer? = null
        lateinit var hilo : Thread
        const val CHANNEL_ID = "Musica Channel"

        // Iniciamos Servicio + Notificacion

        fun startService(context: Context) {
            hilo.run{val startIntent = Intent(context, NoSeSiVivirOMorir::class.java)
            ContextCompat.startForegroundService(context, startIntent)
            mp = MediaPlayer.create(context, R.raw.ibai)}
        }

        // Destruimos servicio

        fun stopService(context: Context) {
            hilo.run{
                val stopIntent = Intent(context, NoSeSiVivirOMorir::class.java)
                context.stopService(stopIntent)}
                hilo.destroy()
        }

        // Funciones del Servicio

        fun reproducir(){
            hilo.run{mp?.start()}
        }
        fun pausa(){
            hilo.run{mp?.pause()}
        }
        fun bloquear(){
            hilo.run{
                sleep(150000)
            }


        }
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

    // Configuramos notificacion

        createNotificationChannel()
        val notificationIntent = Intent(this, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0)
        val notification: Notification = NotificationCompat.Builder(this, CHANNEL_ID).setContentTitle("Reproduciendo musicota").setContentText("No se si vivir o morir!").setSmallIcon(R.drawable.ic_launcher_foreground).setCategory(NotificationCompat.CATEGORY_STATUS).setContentIntent(pendingIntent).build()
        startForeground(1, notification)
        return START_NOT_STICKY
    }

    // Configuramos canal de notificaciones

    private fun createNotificationChannel(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val serviceChannel = NotificationChannel(
                CHANNEL_ID,
                "PAC_LOW",
                NotificationManager.IMPORTANCE_LOW
            )
            val manager = getSystemService(NotificationManager::class.java)
            manager.createNotificationChannel(serviceChannel)
        }
    }
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}