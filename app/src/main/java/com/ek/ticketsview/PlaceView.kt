package com.ek.ticketsview

import android.content.Context
import android.graphics.*
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.util.AttributeSet
import android.util.Log
import android.view.Gravity
import android.widget.Button

class PlaceView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    _color: Int = Color.GRAY,
    _cornerRadius: Float = 20f,
    type: Int = 1
) : androidx.appcompat.widget.AppCompatButton(context, attrs, defStyleAttr) {

    private var placeBackground: Int = _color
    private var cornerRadius = _cornerRadius

    init {
        isClickable = true
        when (type) {
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
        gravity = Gravity.CENTER
    }

    override fun performClick(): Boolean {
        if ((background as ColorDrawable).color == Color.WHITE)
            return super.performClick()

        if ((background as ColorDrawable).color == Color.GRAY)
            setBackgroundColor(Color.RED)
        else
            setBackgroundColor(Color.GRAY)

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

//        drawPlace(canvas)

        Log.d("PLACE DRAWER", "x -> $x, y -> $y ")
    }
//
//    private fun drawPlace(canvas: Canvas?) {
//
//        val rect = RectF(
//            0f,
//            0f,
//            width.toFloat(),
//            height.toFloat()
//        )
//
//        val paint: Paint = Paint().apply { this.color = placeBackground}
//        canvas?.drawRoundRect(rect, cornerRadius, cornerRadius, paint)
//    }
}