package com.ghost.moviedb.repository

import com.ghost.moviedb.model.PopularMovieApiModel
import com.ghost.moviedb.network.api.GetMovieApi
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface MovieRepository {
    fun getPopularMovie(language: String?, page: Int): Flow<PopularMovieApiModel>
}

class MovieRepositoryImpl @Inject constructor(
    private val movieApi: GetMovieApi
) : MovieRepository {

    override fun getPopularMovie(language: String?, page: Int): Flow<PopularMovieApiModel> {
        return movieApi.getPopularMovies(language, page)
    }
}