package com.example.myapplication2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CalendarView
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale


class CalendarView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar_view)
        title = "CalendarView"

        val cvDatum: CalendarView = findViewById(R.id.cvDatum)

        val sdf = SimpleDateFormat(
            "dd.MM.yyyy", Locale.getDefault())
        val kal = Calendar.getInstance()
        kal.set(2019, 6, 15)
        cvDatum.date = kal.timeInMillis
        var ausgabe = "Datum: " + sdf.format(kal.time)
        val textView: TextView = findViewById(R.id.textView4)
        textView.text = ausgabe
        kal.set(2019, 5, 20)
        cvDatum.minDate = kal.timeInMillis
        kal.set(2019, 7, 10)
        cvDatum.maxDate = kal.timeInMillis
        cvDatum.setOnDateChangeListener {
                _, year, month, dayOfMonth ->
            val kalAuswahl = Calendar.getInstance()
            kalAuswahl.set(year, month, dayOfMonth)
            ausgabe = "Datum: " + sdf.format(kalAuswahl.time)
            textView.text = ausgabe
        }
    }
}