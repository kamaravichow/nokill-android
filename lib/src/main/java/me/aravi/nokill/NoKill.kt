package me.aravi.nokill

import android.os.Handler
import android.os.Looper


class NoKill {
    private var mCrashHandler: CrashHandler? = null
    private var instance: NoKill? = null

    fun init(crashHandler: CrashHandler) {
        getInstance()?.setCrashHandler(crashHandler)
    }

    private fun getInstance(): NoKill? {
        if (instance == null) {
            synchronized(NoKill::class.java) {
                if (instance == null) {
                    instance = NoKill()
                }
            }
        }
        return instance
    }

    private fun setCrashHandler(crashHandler: CrashHandler) {
        mCrashHandler = crashHandler
        Handler(Looper.getMainLooper()).post {
            while (true) {
                try {
                    Looper.loop()
                } catch (e: Throwable) {
                    if (mCrashHandler != null) {
                        mCrashHandler!!.uncaughtException(Looper.getMainLooper().thread, e)
                    }
                }
            }
        }
        Thread.setDefaultUncaughtExceptionHandler { t, e ->
            if (mCrashHandler != null) {
                mCrashHandler!!.uncaughtException(t, e)
            }
        }
    }


}