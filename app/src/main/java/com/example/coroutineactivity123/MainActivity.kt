package com.example.coroutineactivity123

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.TextView
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val timer = findViewById<TextView>(R.id.timer)
        val startButton = findViewById<TextView>(R.id.startButton)


        val scope = CoroutineScope(Job() + Dispatchers.Default)

        startButton.setOnClickListener {

            scope.launch {
                repeat(100) {
                    (100 - it).toString().run {
                        Log.d("Countdown", this)
                        delay(1000)
                        withContext(Dispatchers.Main) {
                            timer.text = this@run
                        }
                    }
                }
            }

        }



    }
}