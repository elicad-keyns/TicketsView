package com.ek.ticketsview

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.ScaleGestureDetector
import android.view.View
import kotlin.math.max
import kotlin.math.min


class TicketView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var places = arrayOf(
        arrayOf(1, 1, 0, 1, 1, 1, 2, 2, 0, 1, 1, 0, 1, 1, 2),
        arrayOf(1, 1, 2, 2, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 2),
        arrayOf(1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2)
    )

    private var paddingHorizontal = 20f
    private var paddingVertical = 20f
    private var cScreenHeight = 100f
    private var cornerRadius = 10f

    private var placeSide = 50f

    private var centerX = width / 2
    private var centerY = height / 2

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)

    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        Log.d("TicketView", "onMeasure")
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        Log.d("TicketView", "onAttachedToWindow")

    }

    override fun onLayout(p0: Boolean, p1: Int, p2: Int, p3: Int, p4: Int) {
        super.onLayout(p0, left, top, right, bottom)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        Log.d("TicketView", "onDraw")

        var countPlaces: Int = 0

        for (row in places) {
            if (countPlaces < row.size)
                countPlaces = row.size
        }


        placeSide = width / countPlaces.toFloat()
        paddingHorizontal = placeSide / 8
        paddingVertical = placeSide / 8
        placeSide = (width - paddingHorizontal * (countPlaces + 1)) / countPlaces

        drawScreen(canvas)
        drawPlaces(canvas)
    }

    private fun drawScreen(canvas: Canvas?) {
        val textRect = Rect()

        val textPaint = Paint().apply {
            color = Color.BLACK
            textSize = 50.0f
            textAlign = Paint.Align.CENTER
        }

        val text = "Экран"
        textPaint.getTextBounds(text, 0, text.length, textRect)

        val rect = RectF(
            paddingHorizontal,
            paddingVertical,
            width - paddingHorizontal,
            paddingVertical + cScreenHeight
        )
        val paint = Paint().apply { color = Color.GRAY }

        // CinemaScreen
        canvas?.drawRoundRect(rect, cornerRadius, cornerRadius, paint)
        canvas?.drawText(
            text,
            width / 2.0f,
            paddingVertical + (cScreenHeight / 2) + (textRect.height() / 2),
            textPaint
        )
    }

    fun updatePlaces(_places: Array<Array<Int>>) {
        places = _places
        requestLayout()
    }

    private fun drawPlaces(canvas: Canvas?) {
        var x: Float = paddingHorizontal
        var y: Float = paddingVertical + cScreenHeight + paddingVertical

        for (row in places) {
            for (place in row) {
                when(place) {
                    0 -> {
                        drawPlace(x, y, canvas, isPlace = false, isBuy = false)
                        x += placeSide + paddingHorizontal
                    }
                    1 -> {
                        drawPlace(x, y, canvas, isPlace = true, isBuy = false)
                        x += placeSide + paddingHorizontal
                    }
                    2 -> {
                        drawPlace(x, y, canvas, isPlace = true, isBuy = true)
                        x += placeSide + paddingHorizontal
                    }
                }
            }
            x = paddingHorizontal
            y += placeSide + paddingVertical
        }
    }

    private fun drawPlace(x: Float, y: Float, canvas: Canvas?, isPlace: Boolean, isBuy: Boolean) {
        val rect = RectF(
            x,
            y,
            x + placeSide,
            y + placeSide
        )

        val paint = Paint()

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