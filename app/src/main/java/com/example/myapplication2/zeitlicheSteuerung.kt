package com.example.myapplication2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.os.Handler
import android.widget.Button


class zeitlicheSteuerung : AppCompatActivity() {
    private var zaehler = 0
    private var ausgabe = ""



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_zeitliche_steuerung)

        val textView: TextView = findViewById(R.id.textAusgabe)

        //private val pbAusgabe: ProgressBar = findViewById(R.id.pbAusgabe)
        val buttonStart: Button = findViewById(R.id.buttonStart)
        val buttonPause: Button = findViewById(R.id.buttonPause)
        val buttonStop: Button = findViewById(R.id.buttonStop)

        val steuerung = Handler()


        fun startZustand() {
            zaehler = 0
            ausgabe = ""
            textView.text = ausgabe
            buttonStart.isEnabled = true
            buttonPause.isEnabled = false
            buttonStop.isEnabled = false
            buttonStart.text = "Start"
            //pbAusgabe.progress = zaehler
        }

        startZustand()

        val ereignis = object:Runnable {
            override fun run() {
                zaehler++
                //pbAusgabe.progress = zaehler
                ausgabe += "%d\n".format(zaehler)
                textView.text = ausgabe
                if(zaehler <= 9)
                    steuerung.postDelayed(this, 500L) else
                    startZustand()
            } }

        buttonStart.setOnClickListener {
            buttonStart.isEnabled = false
            buttonPause.isEnabled = true
            buttonStop.isEnabled = true
            steuerung.postDelayed(ereignis, 0L)
            }
        buttonPause.setOnClickListener{
            buttonStart.isEnabled = true
            buttonStart.text = "Weiter"
            buttonPause.isEnabled = false
            steuerung.removeCallbacks(ereignis)
            }
        buttonStop.setOnClickListener {
            buttonStart.isEnabled = true
            buttonPause.isEnabled = false
            buttonStop.isEnabled = false
            steuerung.removeCallbacks(ereignis)
            startZustand()
            }



        }


}

/*
<ProgressBar
        android:id="@+id/pbAusgabe"
        style="?android:attr/progressBarStyleHorizontal"
        android:layout_width="match_parent"
        android:layout_marginTop="137dp"
        android:max="10"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
 */