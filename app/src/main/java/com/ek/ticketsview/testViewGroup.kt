package com.ek.ticketsview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import kotlin.math.max

class testViewGroup @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {

    private val screen = ScreenView(context)

    private val places: ArrayList<ArrayList<Int>> = arrayListOf(
        arrayListOf(1, 1, 0, 1, 1, 0, 1, 1),
        arrayListOf(1, 1, 0, 1, 1, 0, 1, 1),
        arrayListOf(1, 1, 1, 1, 1, 1, 1, 1)
    )

    private var maxPlaces: Int = 1
    private var screenHeight = 100
    private var placeSide = 50
    private var margin = 10

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        super.onLayout(changed, l, t, r, b)

        getMaxPlacesInRow()
        calculatePlaceWidth()

        createScreen()
        createPlaces(places)
    }

    fun calculatePlaceWidth() {
        placeSide = width / maxPlaces
        margin = placeSide / 8
        placeSide = (width - margin * (maxPlaces + 1)) / maxPlaces
    }

    fun getMaxPlacesInRow() {
        for (row in places)
            if (row.size > maxPlaces)
                maxPlaces = row.size
    }

    private fun createScreen() {
        screen.layout(
            margin,
            margin,
            width - margin,
            margin + screenHeight
        )
        this.addView(screen)
    }

    private fun createPlaces(_places: ArrayList<ArrayList<Int>>) {
        var x = margin
        var y = margin + screenHeight + margin

        for (row in _places) {
            row.forEachIndexed() { index, place ->
                val placeView = PlaceView(context, type = place).apply {
                    text = (index + 1).toString()
                }

                placeView.layout(
                    x,
                    y,
                    x + placeSide,
                    y + placeSide
                )

                x += placeSide + margin
                this.addView(placeView)
            }

            x = margin
            y += placeSide + margin
        }
    }

}