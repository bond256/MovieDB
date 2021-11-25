package com.ghost.moviedb.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.ghost.moviedb.base.recycler.BaseAdapter
import com.ghost.moviedb.base.recycler.BaseViewHolder
import com.ghost.moviedb.databinding.ItemDiscoverFilmsBinding
import com.ghost.moviedb.model.ItemFilm

class ListOfFilmsAdapter : BaseAdapter<ItemFilm>() {

    private var listener: OnItemListener? = null

    fun setOnItemListener(onItemListener: OnItemListener) {
        this.listener = onItemListener
    }

    override fun compare(old: ItemFilm, new: ItemFilm): Boolean {
        return old == new
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<ItemFilm> {
        return FilmViewHolder(
            ItemDiscoverFilmsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    inner class FilmViewHolder(val binding: ItemDiscoverFilmsBinding) :
        BaseViewHolder<ItemFilm>(binding.root) {
        override fun bind(item: ItemFilm, position: Int) {
            binding.title.text = item.originalTitle
            binding.rating.text = item.popularity.toString()
            binding.languageOfFilm.text = item.originalLanguage
            loadPoster(POSTER_BASE_URL + item.posterPath, binding.posterImage, binding.root.context)
            binding.root.setOnClickListener { listener?.onItemClick(item) }
        }
    }

    private fun loadPoster(posterUrl: String?, view: ImageView?, context: Context) {
        view?.let {
            Glide.with(context)
                .load(posterUrl)
                .into(it)
        }
    }

    interface OnItemListener {
        fun onItemClick(item: ItemFilm)
    }

    companion object {
        private const val POSTER_BASE_URL = "https://image.tmdb.org/t/p/w342"
    }
}