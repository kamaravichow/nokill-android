package me.aravi.nokill

interface CrashHandler {
    fun uncaughtException(t: Thread, e: Throwable)
}