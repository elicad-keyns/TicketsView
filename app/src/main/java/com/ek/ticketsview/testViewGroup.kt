package com.ek.ticketsview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.util.AttributeSet
import android.view.ViewGroup
import android.widget.TableLayout
import android.widget.TableRow
import androidx.constraintlayout.widget.ConstraintLayout

class testViewGroup @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : TableLayout(context, attrs) {

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
    }

    fun addViews(rows: Int, columns: Int) {
        for (i in 0..rows) {
            val tableRows = TableRow(context)
            tableRows.layoutParams = LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT
            )
            for (j in 0..columns) {
                val placeView = PlaceView(context).apply {
                    width = 100
                    height = 100
                }
                tableRows.addView(placeView, j)
            }
            this@testViewGroup.addView(tableRows, i)
        }
    }

    override fun onLayout(p0: Boolean, p1: Int, p2: Int, p3: Int, p4: Int) {
    }
}