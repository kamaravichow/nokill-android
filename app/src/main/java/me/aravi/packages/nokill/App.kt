package me.aravi.packages.nokill

import android.app.Application
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import me.aravi.nokill.CrashHandler
import me.aravi.nokill.NoKill


class App : Application() {

    override fun onCreate() {
        super.onCreate()

        // initialise no kill
        NoKill().init(object : CrashHandler {
            override fun uncaughtException(t: Thread, e: Throwable) {
                showToastOnUIThread(e.message)
            }
        })


    }


    fun showToastOnUIThread(message: String?) {
        Handler(Looper.getMainLooper()).post {
            Toast.makeText(
                applicationContext,
                message,
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}