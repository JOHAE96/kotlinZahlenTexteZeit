package com.example.myapplication2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.util.Date
import java.text.SimpleDateFormat

import java.util.Calendar
import java.util.Locale

class Zeitangaben : AppCompatActivity() {
    private val datumSDF = SimpleDateFormat(
        "dd.MM.yyyy", Locale.getDefault())
    private val uhrzeitSDF = SimpleDateFormat(
        "HH:mm:ss", Locale.getDefault())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_zeitangaben)
        title = "zeitangaben"

        var kal: Calendar
        var datum: Date
        val lokal = Locale.getDefault()
        val textView: TextView = findViewById(R.id.textView3)


        val buttonGetTime: Button = findViewById(R.id.buttonGetTime)
        buttonGetTime.setOnClickListener {
            kal = Calendar.getInstance()
            datum = kal.time

            var sdf = SimpleDateFormat(
                "dd.MM.yyyy HH:mm:ss,SSS", lokal
            )
            var ausgabe = "Aktuell: " + sdf.format(datum)
            sdf = SimpleDateFormat("D", lokal)
            ausgabe += "\nTag im Jahr: " + sdf.format(datum)

            textView.text = ausgabe
        }
        val buttonSet: Button = findViewById(R.id.buttonSet)
        buttonSet.setOnClickListener {
            kal = Calendar.getInstance()
            kal.set(2019, 11, 20, 15, 39, 52)
            var sdf = SimpleDateFormat(
                "dd.MM.yyyy HH:mm:ss,SSS", lokal
            )
            var ausgabe = sdf.format(kal.time) + " set(), alle\n"
            kal.set(Calendar.MONTH, 0)
            kal.set(Calendar.HOUR_OF_DAY, 14)
            kal.set(Calendar.SECOND, -70)
            ausgabe += sdf.format(kal.time) + " set(), einzeln\n"
            kal.add(Calendar.MINUTE, -70)
            ausgabe += sdf.format(kal.time) + " add()\n"
            kal.roll(Calendar.MINUTE, -70)
            ausgabe += sdf.format(kal.time) + " roll()"
            textView.text = ausgabe
        }
        val buttonMessen: Button = findViewById(R.id.buttonMessen)
        buttonMessen.setOnClickListener {
            val kalBeginn = Calendar.getInstance()
            var z = 0
            while (z < 1.5e8)
                z++
            val kalEnde = Calendar.getInstance()
            val diffSekunden = (kalEnde.timeInMillis -
                kalBeginn.timeInMillis) / 1000.0
            textView.text = "Differenz in Sekunden: %.3f"
                .format(diffSekunden)
        }

        val jetzt = Calendar.getInstance().time
        val editTextDate: EditText = findViewById(R.id.editTextDate)
        val editTextTime: EditText = findViewById(R.id.editTextTime)
        editTextDate.setText(datumSDF.format(jetzt))
        editTextTime.setText(uhrzeitSDF.format(jetzt))

        val buttonEingabeDate: Button = findViewById(R.id.buttonEingabeDate)
        buttonEingabeDate.setOnClickListener {
            val datum = editTextDate.text.toString()
            val teile = datum.split(".")
            if(teile.size != 3 || teile[0].length < 1 || teile[1].length < 1 || teile[2].length != 4) {
                textView.text = "Bitte gemäß Format dd.MM.yyyy" + datum
            } else {
                var ausgabe = "Datum: "
                try {
                    val datum = datumSDF.parse(datum)
                    val kal = Calendar.getInstance()
                    kal.time = datum
                    ausgabe += datumSDF.format(kal.time) }
                catch (ex:Exception) {
                    ausgabe += "nicht gültig" }
                textView.text = ausgabe }
        }



    val buttonEingabeTime: Button = findViewById(R.id.buttonEingabeTime)
    buttonEingabeTime.setOnClickListener {
        val time = editTextTime.text.toString()
        var ausgabe = "Uhrzeit:"
        try {
            val uhrzeit = uhrzeitSDF.parse(time)
            kal = Calendar.getInstance()
            kal.time = uhrzeit
            ausgabe += uhrzeitSDF.format(kal.time) }
        catch (ex:Exception) {
            ausgabe += "nicht gültig" }
        textView.text = ausgabe

    }

    }
}