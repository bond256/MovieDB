package com.ghost.moviedb.base.recycler

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ghost.moviedb.base.autoNotify
import kotlin.properties.Delegates

abstract class BaseAdapter<T> : RecyclerView.Adapter<BaseViewHolder<T>>() {
    val items: List<T> by Delegates.observable(emptyList()) { _, oldList, newList ->
        autoNotify(oldList, newList) { old, new -> compare(old, new) }
    }

    abstract fun compare(old: T, new: T): Boolean

    override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int) {
        holder.bind(items[position], position)
    }

    override fun getItemCount(): Int = items.size
}