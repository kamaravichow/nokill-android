package me.aravi.packages.nokill

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.normal_error).setOnClickListener {
            makeError()
        }

        findViewById<Button>(R.id.runtime_crash).setOnClickListener {
            makeRuntimeExeption()
        }

        findViewById<Button>(R.id.illegal_state_crash).setOnClickListener {
            makeIllegalStateException()
        }

        findViewById<Button>(R.id.background_crash).setOnClickListener {
            makeExceptionOnBackgroundThread()
        }
    }

    fun makeRuntimeExeption() {
        throw RuntimeException("Some kind of runtime exception")
    }

    fun makeError() {
        throw Error("Some kind of ERROR")
    }

    fun makeIllegalStateException() {
        throw IllegalStateException("Some kind of Illegal State Exeption")
    }

    fun makeExceptionOnBackgroundThread() {
        Thread {
            throw java.lang.RuntimeException("Exception in background thread")
        }.start()
    }
}