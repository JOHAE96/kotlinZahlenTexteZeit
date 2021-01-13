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
        title = "Zahlen"

        var ausgabe = "Konstanten:\n"
        ausgabe += "E: %.20f\n".format(E)
        ausgabe += "PI: %.20f\n\n".format(PI)

        ausgabe += " Betrag, Vorzeichen, Rundung und Extremwerte:\n"
        val r1 = 4.75
        val r2 = -4.75
        ausgabe += "Werte: %.2f %.2f\n".format(r1, r2)
        ausgabe += "absoluteValue: %.2f %.2f\n".format(r1.absoluteValue, r2.absoluteValue)
        ausgabe += "sign: %.0f %.0f\n".format(r1.sign, r2.sign)
        ausgabe += "round(): %.0f %.0f, \n".format(round(r1), round(r2))

        ausgabe += "truncate(): %.0f %.0f\n".format(truncate(r1), truncate(r2))
        ausgabe += "ceil(): %.0f %.0f\n".format(ceil(r1), ceil(r2))
        ausgabe += "floor(): %.0f %.0f\n".format(floor(r1), floor(r2))
        ausgabe += "max(): %.2f, ".format(max(r1, r2))
        ausgabe += "min(): %.2f\n\n".format(min(r1, r2))

        ausgabe += "Winkelfunktionen:\n"
        val w = 30.0 //grad
        val wbm = w * PI / 180 //bogenmaß
        ausgabe += "sin(): %f\n".format(sin(wbm))
        ausgabe += "cos(): %f\n".format(cos(wbm))
        ausgabe += "tan(): %f\n\n".format(tan(wbm))

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