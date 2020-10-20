package com.ek.ticketsview

import android.content.Context
import android.graphics.*
import android.util.AttributeSet

class RowView  @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    _rowId: Int = 0
) : androidx.appcompat.widget.AppCompatTextView(context, attrs, defStyleAttr) {

    private var rowId = _rowId

    private var centerX = width / 2
    private var centerY = height / 2

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        drawRowName(canvas)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    private fun drawRowName(canvas: Canvas?) {
        val textRect = Rect()

        val textPaint = Paint().apply {
            color = Color.BLACK
            textSize = 50.0f
            textAlign = Paint.Align.CENTER
        }

        val text = rowId.toString()
        textPaint.getTextBounds(text, 0, text.length, textRect)

        canvas?.drawText(
            text,
            width / 2.0f,
            (height / 2f) + (textRect.height() / 2),
            textPaint
        )
    }

}