package com.example.pacdesarrollouf2

import android.app.*
import android.content.Intent
import android.media.MediaPlayer
import android.os.Build
import android.os.IBinder
import androidx.core.app.NotificationCompat
import org.greenrobot.eventbus.EventBus

class NoSeSiVivirOMorir : Service(){
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        createNotificationChannel()
        val notificationIntent = Intent(this, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0)
        val notification: Notification = NotificationCompat.Builder(this, CHANNEL_ID).setContentTitle("Reproduciendo musicota").setContentText("No se si vivir o morir!").setSmallIcon(R.drawable.ic_launcher_foreground).setContentIntent(pendingIntent).build()
        startForeground(1, notification)
        Thread {
            run {
                EventBus.getDefault().post("NoSeSiVivirOMorir")
                val mp = MediaPlayer.create(this, R.raw.ibai)
                mp.start()
                stopSelf()
            }
        }.start()
        return START_NOT_STICKY
    }
    private fun createNotificationChannel(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val serviceChannel = NotificationChannel(
                CHANNEL_ID,
                "PAC",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            val manager = getSystemService(NotificationManager::class.java)
            manager.createNotificationChannel(serviceChannel)
        }
    }
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
    companion object {
        const val CHANNEL_ID = "Musica Channel"
    }
}