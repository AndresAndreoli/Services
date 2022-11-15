package com.example.services

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class MyBroadcastReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.getAction().equals(Intent.ACTION_BOOT_COMPLETED)) {
            val serviceIntent = Intent(context, MyForegroundService::class.java)
            context?.startForegroundService(serviceIntent)
        }
    }
}