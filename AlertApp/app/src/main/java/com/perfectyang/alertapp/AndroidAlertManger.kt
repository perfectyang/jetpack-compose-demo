package com.perfectyang.alertapp

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.os.SystemClock

class AndroidAlertManger (
    private val context : Context,
) {
    private val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager



    fun scheduleAlarm () {
        val fiveSeconds = 1000 * 5

//        val pendingIntent = PendingIntent.getBroadcast()
//
//        alarmManager.setExactAndAllowWhileIdle(
//            AlarmManager.RTC_WAKEUP,
//            SystemClock.elapsedRealtime() + fiveSeconds,
//            {
//
//            }
//        )




    }



}