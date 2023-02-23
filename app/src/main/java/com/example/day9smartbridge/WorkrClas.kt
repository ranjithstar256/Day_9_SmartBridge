package com.example.day9smartbridge

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class WorkrClas(context: Context, workerParams: WorkerParameters)
    : Worker(context, workerParams) {

    override fun doWork(): Result {
        val context: Context = getApplicationContext()
        return try {
            Log.d(TAG, "doWork Called")
            UtilsClas.sendNotification(context)
            Result.success()
        } catch (throwable: Throwable) {
            Log.d(TAG, "Error Sending Notification" + throwable.message)
            Result.failure()
        }
    }

    companion object {
        private val TAG = WorkrClas::class.java.name
    }
}