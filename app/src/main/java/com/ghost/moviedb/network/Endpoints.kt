package com.ghost.moviedb.network

object Movie {
    private const val movie = "movie"
    private const val id = "/{id}"
    const val POPULAR_MOVIE = "$movie/popular"
    const val DETAILS_MOVIE = "$movie$id"
    const val Videos_MOVIE = "$movie$id/videos"
}