package com.example.assignment2

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class Receiver: BroadcastReceiver() {
    override fun onReceive(p0: Context?, intent: Intent?) {
        val isAirplaneModeEnabled = intent?.getBooleanExtra("state", false) ?:return
        if (isAirplaneModeEnabled) {
            Toast.makeText(p0, "Airplane Mode Enabled", Toast.LENGTH_LONG).show()
        }
    }
}