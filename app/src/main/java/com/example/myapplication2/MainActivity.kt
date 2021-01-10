package com.example.myapplication2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val buttonZahlen:Button = findViewById(R.id.buttonZahlen)
        buttonZahlen.setOnClickListener {
            val intent = Intent(this@MainActivity, math::class.java )
            startActivity(intent)
        }

        val buttonZeichenketten:Button = findViewById(R.id.buttonZeichenketten)
        buttonZeichenketten.setOnClickListener {
            val intent = Intent(this@MainActivity, Zeichenketten::class.java )
            startActivity(intent)
        }
        val buttonZeitangaben:Button = findViewById(R.id.buttonZeitangaben)
        buttonZeitangaben.setOnClickListener {
            val intent = Intent(this@MainActivity, Zeitangaben::class.java )
            startActivity(intent)
        }
        val buttonCalendarView:Button = findViewById(R.id.buttonCalendarView)
        buttonCalendarView.setOnClickListener {
            val intent = Intent(this@MainActivity, CalendarView::class.java )
            startActivity(intent)
        }
        val buttonDatePicker:Button = findViewById(R.id.buttonDatePicker)
        buttonDatePicker.setOnClickListener {
            val intent = Intent(this@MainActivity, DatePickerView::class.java )
            startActivity(intent)
        }
        val buttonTimePicker:Button = findViewById(R.id.buttonTimePicker)
        buttonTimePicker.setOnClickListener {
            val intent = Intent(this@MainActivity, TimePickerView::class.java )
            startActivity(intent)
        }
        val buttonZeitlicheSteuerung:Button = findViewById(R.id.buttonZeitlicheSteuerung)
        buttonZeitlicheSteuerung.setOnClickListener {
            val intent = Intent(this@MainActivity, zeitlicheSteuerung::class.java )
            startActivity(intent)
        }
        val buttonMulti:Button = findViewById(R.id.buttonMulti)
        buttonMulti.setOnClickListener {
            val intent = Intent(this@MainActivity, mehrereSteuerungen::class.java )
            startActivity(intent)
        }
    }
}