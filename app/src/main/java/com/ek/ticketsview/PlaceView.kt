package com.ek.ticketsview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.util.Log
import android.view.View

class PlaceView @JvmOverloads constructor(
    context: Context,
    _placeStyle: Int,
    _placeSide: Int,
    _isPlace: Boolean,
    _isBuy: Boolean,
    _cornerRadius: Float = 0f,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var placeStyle = _placeStyle
    private var placeSide = _placeSide
    private var isPlace = _isPlace
    private var isBuy = _isBuy
    private var cornerRadius = _cornerRadius

    private val rect = RectF(
        x,
        y,
        x + placeSide,
        y + placeSide
    )

    private val paint = Paint()

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        if (isPlace)
            paint.color = Color.GRAY
        else
            paint.color = Color.WHITE

        if (isBuy)
            paint.color = Color.RED

        canvas?.drawRoundRect(rect, cornerRadius, cornerRadius, paint)

        Log.d("PLACE DRAWER", "x -> $x, y -> $y ")
    }
}