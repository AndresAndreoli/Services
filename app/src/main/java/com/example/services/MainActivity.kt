package com.example.services

import android.app.ActivityManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ---- STARTING BACKGROUND SERVICE ----
        /*
        var intent = Intent(this, MyForegroundService::class.java)
        startService(intent)
        */

        // ---- STARTING FOREGROUND SERVICE ----
        if (!foregroundServiceRunning()){
            var intent = Intent(this, MyForegroundService::class.java)
            startForegroundService(intent)
        }
    }


    fun foregroundServiceRunning(): Boolean {
        val activityManager = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        // It will iterate for each service that is running
        for (service in activityManager.getRunningServices(Int.MAX_VALUE)) {
            if (MyForegroundService::class.java.name == service.service.className) {
                return true
            }
        }
        return false
    }
}