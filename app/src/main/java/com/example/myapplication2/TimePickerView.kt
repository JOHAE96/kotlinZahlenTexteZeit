package com.example.myapplication2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.TimePicker
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale


class TimePickerView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time_picker_view)
        val textView: TextView = findViewById(R.id.textView6)
        val tpUhrzeit: TimePicker = findViewById(R.id.tpUhrzeit)
        var sdf = SimpleDateFormat(
                "HH:mm", Locale.getDefault())

        val kal = Calendar.getInstance()
        var ausgabe = "Uhrzeit: " + sdf.format(kal.time)
        textView.text = ausgabe
        tpUhrzeit.setIs24HourView(true)
        tpUhrzeit.setOnTimeChangedListener {
                _, hourOfDay, minute ->
            val kalAuswahl = Calendar.getInstance()
            kalAuswahl.set(Calendar.HOUR_OF_DAY, hourOfDay)
            kalAuswahl.set(Calendar.MINUTE, minute)
            ausgabe = "Uhrzeit: " + sdf.format(kalAuswahl.time) + "\n"
            textView.text = ausgabe
        }
    }
}