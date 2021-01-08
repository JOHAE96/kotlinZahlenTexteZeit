package com.example.myapplication2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

import kotlin.math.*

class math : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_math)

        var ausgabe = "Konstanten:\n"
        ausgabe += "E: %.20f\n".format(E)
        ausgabe += "PI: %.20f\n\n".format(PI)

        val textView: TextView = findViewById(R.id.textView)
        textView.text = ausgabe

    }
}