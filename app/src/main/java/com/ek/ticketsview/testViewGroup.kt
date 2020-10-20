package com.ek.ticketsview

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.widget.Button
import android.widget.RelativeLayout
import androidx.core.content.ContextCompat

class testViewGroup @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {

    private var places: ArrayList<ArrayList<Int>> = arrayListOf(
        arrayListOf(1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1),
        arrayListOf(1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1),
        arrayListOf(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1)
    )

    private var maxPlaces: Int = 1
    private var screenHeight = 100
    private var placeSide = 50
    private var margin = 10

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        getMaxPlacesInRow()
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        super.onLayout(changed, l, t, r, b)

        // getMaxPlacesInRow()
        calculatePlaceWidth()

        createWidget()

//        createScreen()
//        createPlaces(places)
//        createOutputButton()
    }

    fun createWidget() {
        Log.d("WIDGET CREATOR ->", "WIDGET START CREATING")
        createScreen()
        createPlaces(places)
        createOutputButton()
        Log.d("WIDGET CREATOR ->", "WIDGET CREATED")
    }

    fun setPlaces(_places: ArrayList<ArrayList<Int>>) {
        places = _places
        requestLayout()
    }

    private fun calculatePlaceWidth() {
        placeSide = width / maxPlaces
        margin = placeSide / 8
        placeSide = (width - margin * (maxPlaces + 1)) / maxPlaces
    }

    private fun getMaxPlacesInRow() {
        for (row in places)
            if (row.size > maxPlaces)
                maxPlaces = row.size + 2
    }

    private fun createOutputButton() {
        val button = Button(context)

        button.setOnClickListener {
            Log.d("PLACES DEBUGGER", places.toString())
        }

        button.layout(
            margin,
            height - screenHeight - margin,
            width - margin,
            height - margin
        )
        this.addView(button)
    }

    private fun createScreen() {
        val screen = ScreenView(context)
        screen.layout(
            margin,
            margin,
            width - margin,
            margin + screenHeight
        )
        this.addView(screen)
    }

    private fun createRowView(_x: Int, _y: Int, _rowId: Int) {
        val rowView = RowView(context, _rowId = _rowId)
        rowView.layout(
            _x,
            _y,
            _x + placeSide,
            _y + placeSide
        )

        this.addView(rowView)
    }

    private fun createPlaceView(_x: Int, _y: Int, _placeId: Int, _indexRow: Int, _indexColumn: Int, _place: Int) {
        val placeView = PlaceView(context, _type = _place)
        placeView.setOnClickListener {
            when (places[_indexRow][_indexColumn]) {
                1 -> places[_indexRow][_indexColumn] = 2
                2 -> places[_indexRow][_indexColumn] = 1
            }
        }

        placeView.text = _placeId.toString()

        placeView.layout(
            _x,
            _y,
            _x + placeSide,
            _y + placeSide
        )
        this.addView(placeView)
    }

    private fun createPlaces(_places: ArrayList<ArrayList<Int>>) {
        var x = margin
        var y = margin + screenHeight + margin
        var placeId: Int = 1

        _places.forEachIndexed { indexRow, row ->
            createRowView(x, y, indexRow + 1)
            x += placeSide + margin

            row.forEachIndexed { indexColumn, place ->
                createPlaceView(x, y, placeId, indexRow, indexColumn, place)
                placeId++
                x += placeSide + margin
            }

            createRowView(x, y, indexRow + 1)
            x = margin
            y += placeSide + margin
        }
    }


}