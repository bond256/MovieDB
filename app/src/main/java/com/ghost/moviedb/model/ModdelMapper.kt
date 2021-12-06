package com.ghost.moviedb.model


fun mapApiToItem(films: List<Result>): List<ItemFilm> {
    return films.map {
        ItemFilm(
            id = it.id,
            originalTitle = it.originalTitle,
            originalLanguage = it.originalLanguage,
            voteAverage = it.voteAverage,
            posterPath = it.posterPath
        )
    }
}
