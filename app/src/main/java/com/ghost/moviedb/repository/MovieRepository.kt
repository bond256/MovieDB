package com.ghost.moviedb.repository

import com.ghost.moviedb.model.PopularMovieApiModel
import com.ghost.moviedb.network.api.GetMovieApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import com.ghost.moviedb.base.Result
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

interface MovieRepository {
    suspend fun getPopularMovie(language: String?, page: Int): Flow<Result<PopularMovieApiModel>>
}

class MovieRepositoryImpl @Inject constructor(
    private val movieApi: GetMovieApi
) : MovieRepository {

    override suspend fun getPopularMovie(
        language: String?,
        page: Int
    ): Flow<Result<PopularMovieApiModel>> {
        return flow<Result<PopularMovieApiModel>> {
            try {
                val result = movieApi.getPopularMovies(null, 1).await()
                emit(Result.onLoading())
                emit(Result.onSuccess(result))
            } catch (e: Exception) {
                emit(Result.onFailure(e))
            }
        }.flowOn(Dispatchers.IO)
    }
}