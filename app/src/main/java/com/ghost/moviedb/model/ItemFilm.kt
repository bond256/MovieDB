package com.ghost.moviedb.model

data class ItemFilm(
    val id: Int,
    val originalTitle: String,
    val voteAverage: Double,
    val originalLanguage: String,
    val posterPath: String
)
