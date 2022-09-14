package com.example.practicemvvm.mvvm_without_dagger.util

import android.os.CountDownTimer
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class Extra {
     val DATE_FORMAT = "yyyy-MM-dd-hh.mm.ss"

    val timer = object : CountDownTimer(2000L, 2000L) {
        override fun onTick(millisUntilFinished: Long) {

        }

        override fun onFinish() {
        }
    }

    fun getCurrentDateTime(): String {
        val cal: Calendar = Calendar.getInstance()
        val now: Date = cal.time
        val formatter = SimpleDateFormat(DATE_FORMAT)
        return formatter.format(now)
    }

    fun Int.addSecondsToCurrentTime(): String {
        val cal: Calendar = Calendar.getInstance()
        cal.add(Calendar.SECOND, this)
        val futureTime: Date = cal.time
        val formatter = SimpleDateFormat(DATE_FORMAT)
        return formatter.format(futureTime)
    }

    fun String.checkTimeExpired(savedLocalDate: String): Boolean {
        var isTimeExpired = false
        var currentDate: Date?
        var savedDate: Date?
        val dateFormat = SimpleDateFormat(DATE_FORMAT)
        try {
            currentDate = dateFormat.parse(this)
            savedDate = dateFormat.parse(savedLocalDate)
            if (currentDate.compareTo(savedDate) > 0) {
                isTimeExpired = true
            }
        } catch (e: ParseException) {
            e.printStackTrace()
        }

        return isTimeExpired
    }
}