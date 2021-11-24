package com.ghost.moviedb.network.api

import com.ghost.moviedb.model.PopularMovieApiModel
import com.ghost.moviedb.network.Movie
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Query

interface GetMovieApi {

    @GET(Movie.POPULAR_MOVIE)
    fun getPopularMovies(
        @Query("language") language: String?,
        @Query("page") page: Int
    ): Deferred<PopularMovieApiModel>


}