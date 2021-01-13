package com.example.myapplication2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

import android.os.Build
import android.widget.DatePicker
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale


class DatePickerView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_date_picker_view)
        title = "Datepicker"
        val textView: TextView = findViewById(R.id.textView5)
        val dpDatum : DatePicker = findViewById(R.id.dpDatum)
        if (Build.VERSION.SDK_INT >= 26) {
            val sdf = SimpleDateFormat(
                "dd.MM.yyyy", Locale.getDefault())
            val kal = Calendar.getInstance()
            kal.set(2019, 6, 15)
            dpDatum.updateDate(2019, 6, 15)
            val ausgabe = "Datum: " + sdf.format(kal.time)
            textView.text = ausgabe
            kal.set(2019, 5, 20)
            dpDatum.minDate = kal.timeInMillis
            kal.set(2019, 7, 10)
            dpDatum.maxDate = kal.timeInMillis
            dpDatum.setOnDateChangedListener {
                    _, year, monthOfYear, dayOfMonth ->
                val kalAuswahl = Calendar.getInstance()
                kalAuswahl.set(year, monthOfYear, dayOfMonth)
                val aus = "Datum: " + sdf.format(kalAuswahl.time)
                textView.text = aus
            } } else
                 textView.text = "API-Level min. 26, hier: %d".format(Build.VERSION.SDK_INT)


    }
}