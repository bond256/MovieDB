package com.ghost.moviedb.network.api

import com.ghost.moviedb.model.PopularMovieApiModel
import com.ghost.moviedb.model.details.DetailsModelApi
import com.ghost.moviedb.model.videos.VideoModelApi
import com.ghost.moviedb.network.Movie
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GetMovieApi {

    @GET(Movie.POPULAR_MOVIE)
    fun getPopularMovies(
        @Query("language") language: String?,
        @Query("page") page: Int
    ): Deferred<PopularMovieApiModel>

    @GET(Movie.DETAILS_MOVIE)
    fun getMovieDetails(
        @Path("id") id: Int,
        @Query("language") language: String?
    ): Deferred<DetailsModelApi>

    @GET(Movie.Videos_MOVIE)
    fun getMovieVideos(
        @Path("id") id: Int,
        @Query("language") language: String?
    ): Deferred<VideoModelApi>


}