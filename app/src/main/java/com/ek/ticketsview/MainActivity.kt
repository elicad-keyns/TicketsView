package com.ek.ticketsview

import android.app.ActionBar
import android.os.Bundle
import android.text.Layout
import android.util.DisplayMetrics
import android.view.Display
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onStart() {
        super.onStart()

//      Добавляю вьюшки в testViewGroup = Пустой экран
        testViewGroup.addViews(2, 2)
//
//      Добавляю вьюшки программно, все ок
//
//        val displayMetrics = DisplayMetrics()
//        windowManager.defaultDisplay.getMetrics(displayMetrics)
//
//        val screenView = ScreenView(this).apply {
//            x = 10f
//            y = 10f
//            width = displayMetrics.widthPixels - 20
//            height = 100
//        }
//
//        cl_main.addView(screenView)
//
//        val buttonSide = 100f
//        val margin = 10f
//
//        for (i in 0..5) {
//            val button = PlaceView(this).apply {
//                x = margin + (buttonSide + margin) * i
//                y = margin + buttonSide + margin
//                width = buttonSide.toInt()
//                height = buttonSide.toInt()
//            }
//
//            cl_main.addView(button)
//        }
    }
}