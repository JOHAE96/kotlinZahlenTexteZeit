package com.example.myapplication2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.os.Handler

class mehrereSteuerungen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mehrere_steuerungen)
        val textView: TextView = findViewById(R.id.textView8)
        val button1: Button = findViewById(R.id.button1)
        val button2: Button = findViewById(R.id.button2)

        val steuerungEins = Handler()
        val steuerungZwei = Handler()
        var ausgabe = ""
        val ereignisEins = object:Runnable {
            override fun run() {
                ausgabe += "1 "
                textView.text = ausgabe
                steuerungEins.postDelayed(this, 500L)
            }
        }
        button1.setOnClickListener {
            button1.isEnabled = false
            steuerungEins.postDelayed(ereignisEins, 0L) }
        val ereignisZwei = object:Runnable {
            override fun run() {
                ausgabe += "2 "
                textView.text = ausgabe
                steuerungZwei.postDelayed(this, 300L)
            }
        }
        button2.setOnClickListener {
            button2.isEnabled = false
            steuerungZwei.postDelayed(ereignisZwei, 0L) }
    } }