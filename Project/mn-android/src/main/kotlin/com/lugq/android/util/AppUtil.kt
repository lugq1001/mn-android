package com.lugq.android.util

import android.app.ActivityManager
import android.content.Context

object AppUtil {


    fun isAppOnForeground(context: Context): Boolean {
        val activityManager = (context.getSystemService(Context.ACTIVITY_SERVICE) as? ActivityManager)
                ?: return false
        val packageName = context.packageName
        val appProcesses = activityManager.runningAppProcesses ?: return false
        for (appProcess in appProcesses) {
            if (appProcess.processName == packageName && appProcess.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND) {
                return true
            }
        }
        return false
    }

}