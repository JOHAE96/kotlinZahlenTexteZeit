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

        ausgabe += "Wurzel, Exponential- und Logarithmusfunktionen:\n"
        ausgabe += "5.2.pow(3.5): %f\n".format(5.2.pow(3.5))
        ausgabe += "log(320.6, 5.2): %f\n".format(log(320.6, 5.2))
        ausgabe += "sqrt(7.5): %f\n".format(sqrt(7.5))
        ausgabe += "ln(100.0): %f\n".format(ln(100.0))
        ausgabe += "exp(4.6): %f\n\n".format(exp(4.6))

        val textView: TextView = findViewById(R.id.textView)
        textView.text = ausgabe

    }
}