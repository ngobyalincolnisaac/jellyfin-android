package org.jellyfin.android.utils

import android.app.AlertDialog
import android.content.Intent
import android.os.Build
import android.os.PowerManager
import android.provider.Settings
import androidx.appcompat.app.AppCompatActivity
import org.jellyfin.android.BuildConfig
import org.jellyfin.android.R
import org.jellyfin.android.WebappActivity

fun WebappActivity.requestNoBatteryOptimizations() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        val powerManager: PowerManager = getSystemService(AppCompatActivity.POWER_SERVICE) as PowerManager
        if (!appPreferences.ignoreBatteryOptimizations && !powerManager.isIgnoringBatteryOptimizations(BuildConfig.APPLICATION_ID)) {
            val builder: AlertDialog.Builder = AlertDialog.Builder(this)
            builder.setTitle(getString(R.string.battery_optimizations_title))
            builder.setMessage(getString(R.string.battery_optimizations_message))
            builder.setNegativeButton(android.R.string.cancel) { _, _ ->
                appPreferences.ignoreBatteryOptimizations = true
            }
            builder.setPositiveButton(android.R.string.ok) { _, _ ->
                try {
                    val intent = Intent(Settings.ACTION_IGNORE_BATTERY_OPTIMIZATION_SETTINGS)
                    startActivity(intent)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
            builder.show()
        }
    }
}