package com.ghost.moviedb.base.recycler

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<T>(view: View): RecyclerView.ViewHolder(view) {
    abstract fun bind(item: T, position: Int)
}