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
    }
}