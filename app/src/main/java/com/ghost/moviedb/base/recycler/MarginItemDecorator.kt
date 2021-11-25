package com.ghost.moviedb.base.recycler

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class MarginItemDecorator(
    private val top: Int = 0, private val bottom: Int = 0,
    private val left: Int = 0, private val right: Int = 0
) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        with(outRect) {
            if (parent.getChildAdapterPosition(view) == 0) {
                top = this@MarginItemDecorator.top
            }
            left = this@MarginItemDecorator.left
            right = this@MarginItemDecorator.right
            bottom = this@MarginItemDecorator.bottom
        }
    }
}