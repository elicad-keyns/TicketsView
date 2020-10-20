package com.ek.ticketsview

import android.content.Context
import android.graphics.*
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.util.AttributeSet
import android.util.Log
import android.view.Gravity
import android.widget.Button
import androidx.core.content.ContextCompat

class PlaceView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    _color: Int = Color.GRAY,
    _cornerRadius: Float = 20f,
    _type: Int = 1
) : androidx.appcompat.widget.AppCompatButton(context, attrs, defStyleAttr) {

    private var placeBackground: Int = _color
    private var cornerRadius = _cornerRadius

    init {
        isClickable = true
        when (_type) {
            0 ->  {
                setBackgroundColor(Color.WHITE)
                visibility = INVISIBLE
            }
            1 -> {
                setBackgroundColor(Color.GRAY)
            }
            2 -> {
                setBackgroundColor(Color.RED)
            }
        }
        setTextColor(Color.GRAY)
        gravity = Gravity.CENTER
    }

    override fun performClick(): Boolean {

        when ((background as ColorDrawable).color) {
            Color.WHITE -> {
                return super.performClick()
            }
            Color.GRAY -> {
                setBackgroundColor(Color.RED)
                setTextColor(Color.BLACK)
            }
            Color.RED -> {
                setBackgroundColor(Color.GRAY)
                setTextColor(Color.GRAY)
            }
        }
        return super.performClick()
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        Log.d("SIZE CHANGER", "w -> $w, h -> $h, oldW -> $oldw, oldH -> $oldh")
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

        Log.d("PLACE DRAWER", "x -> $x, y -> $y ")
    }
}