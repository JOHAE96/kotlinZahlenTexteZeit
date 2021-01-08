package com.example.myapplication2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Zeichenketten : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_zeichenketten)

        title = "Zeichenketten"

        val tx = "Hallo Welt"
        var ausgabe = "Länge, Zeichen und Teile\n"
        ausgabe += "Gesamte Zeichenkette: %s\n".format(tx)
        ausgabe += "Länge: %d\n".format(tx.length)
        val z1:Char = tx[0]
        val z2 = tx[1]
        val z3 = tx[tx.lastIndex]
        ausgabe += "Einzelne Zeichen: %c %c %c\n".format(z1, z2, z3)
        ausgabe += "Teilzeichenkette: %s\n".format(tx.substring(3,8))
        ausgabe += "Teilzeichenkette: %s\n\n".format(tx.substring(3 .. 8))






        val textView: TextView = findViewById(R.id.textView2)
        textView.text = ausgabe
    }
}