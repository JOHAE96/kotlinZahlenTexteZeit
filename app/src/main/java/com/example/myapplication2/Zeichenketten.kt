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


        ausgabe += "Prüfen, Suchen und Ersetzen\n"

        if(tx.contains("We"))
            ausgabe += "Enthält 'We'\n"
        if(tx.startsWith("Ha"))
            ausgabe += "Beginnt mit 'Ha'\n"
        if(tx.endsWith("elt"))
            ausgabe += "Endet mit 'elt'\n"
        ausgabe += "Positionen von 'l': "
        var pos = tx.indexOf('l')
        while(pos != -1) {
            ausgabe += "%d ".format(pos)
            pos = tx.indexOf('l', pos + 1) }
        ausgabe += "\n"
        ausgabe += "Letzte Position: %d\n".format(tx.lastIndexOf('l'))
        ausgabe += "Ersetzen: %s\n".format(tx.replace('l','n'))
        ausgabe += "Ersetzen: %s\n\n".format(tx.replace("all","ipp"))


        ausgabe += "Unicode, Umwandlung und Vergleich\n"
        val ta = "aBäöüÄÖÜß"
        ausgabe += ta + "\n"
        ausgabe += "Code: "
        for(i in 0 .. ta.lastIndex)
            ausgabe += "%d ".format(ta.codePointAt(i))
        ausgabe += "\n"
        ausgabe += "Groß: %s\n".format(ta.toUpperCase())
        ausgabe += "Klein: %s\n".format(ta.toLowerCase())
        if("Hallo".equals("hallo"))
            ausgabe += "Strings sind gleich, mit Prüfung groß/klein\n"
        if("Hallo".equals("hallo", true))
            ausgabe += "Strings sind gleich, ohne Prüfung groß/klein\n"
        if("Hallo".compareTo("Halli") > 0)
            ausgabe += "Reihenfolge, Hallo nach Halli\n"
        else if("Hallo".compareTo("Halli") < 0)
            ausgabe += "Reihenfolge, Hallo vor Halli\n"
        else
            ausgabe += "Gleich\n"
        if("Hallo".compareTo("hallo", true) == 0)
            ausgabe += "Gleich, ohne Prüfung groß/klein\n\n"


        ausgabe += " Leerzeichen, Trennen und Verbinden\n"
        ausgabe += "og: |%s|\n".format("   Guten Morgen ")
        ausgabe += "Trim: |%s|\n".format("   Guten Morgen ".trim())
        val tb = "Das ist ein Satz"
        ausgabe += "Split: "
        val tbListe = tb.split(" ")
        for(x in tbListe)
            ausgabe += "%s (%d) ".format(x, x.length)
        ausgabe += "\n"
        val tc = tbListe.joinToString(" ")
        ausgabe += "Join: %s\n".format(tc)


        val textView: TextView = findViewById(R.id.textView2)
        textView.text = ausgabe
    }
}