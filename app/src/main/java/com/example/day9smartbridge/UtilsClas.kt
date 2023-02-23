package com.example.day9smartbridge

import android.app.*
import android.content.*
import android.os.Build
import androidx.core.app.NotificationCompat

object UtilsClas {
    const val NOTIFICATION_ID = 22
    private const val CHANNEL_ID = "notify"
    private const val CHANNEL_NAME = "workmanager-reminder"
    fun sendNotification(context: Context) {
        var notificationManager: NotificationManager? = null
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            notificationManager =
                context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel1 = NotificationChannel(
                CHANNEL_ID,
                CHANNEL_NAME,
                NotificationManager.IMPORTANCE_DEFAULT
            )
            channel1.enableVibration(true)
            channel1.enableLights(true)
            channel1.lightColor = R.color.purple_200
            channel1.lockscreenVisibility = Notification.VISIBILITY_PRIVATE
            notificationManager!!.createNotificationChannel(channel1)
        }
        val builder = NotificationCompat.Builder(context, CHANNEL_ID)
            .setContentTitle("WorkManager Sample")
            .setContentText("WorkManager Started")
            .setAutoCancel(true)
            .setSmallIcon(android.R.drawable.ic_menu_share)
        notificationManager!!.notify(1, builder.build())
    }
}