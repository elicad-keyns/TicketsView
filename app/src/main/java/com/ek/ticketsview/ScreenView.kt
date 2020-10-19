package com.ek.ticketsview

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.core.widget.TextViewCompat

class ScreenView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : androidx.appcompat.widget.AppCompatTextView(context, attrs, defStyleAttr) {

    private var centerX = width / 2
    private var centerY = height / 2

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        drawScreen(canvas)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        Log.d("SIZE CHANGER", "w -> $w, h -> $h, oldW -> $oldw, oldH -> $oldh")
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
            0f,
            0f,
            width.toFloat(),
            height.toFloat()
        )
        val paint = Paint().apply { color = Color.GRAY }

        // CinemaScreen
        canvas?.drawRect(rect, paint)
        canvas?.drawText(
            text,
            width / 2.0f,
            (height / 2f) + (textRect.height() / 2),
            textPaint
        )
    }
}