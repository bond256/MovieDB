package com.ghost.moviedb.model



    fun mapApiToItem(films: List<Result>): List<ItemFilm> {
        return films.map {
            ItemFilm(
                originalTitle = it.originalTitle,
                originalLanguage = it.originalLanguage,
                popularity = it.popularity,
                posterPath = it.posterPath
            )
        }
    }
