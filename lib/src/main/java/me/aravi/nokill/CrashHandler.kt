package me.aravi.nokill

import androidx.annotation.Keep

@Keep
interface CrashHandler {
    fun uncaughtException(t: Thread, e: Throwable)
}