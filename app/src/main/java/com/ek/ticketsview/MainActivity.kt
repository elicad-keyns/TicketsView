package com.ek.ticketsview

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val newPlaces = arrayOf(
        arrayOf(1, 0, 1, 1, 1, 0, 2, 2, 0, 1, 1, 2, 1, 1, 2),
        arrayOf(1, 0, 2, 2, 0, 0, 1, 1, 0, 1, 1, 2, 1, 1, 2),
        arrayOf(1, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 2, 2, 1)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onStart() {
        super.onStart()

        b_add.setOnClickListener {
            ticketView.updatePlaces(_places = newPlaces)
        }
    }
}