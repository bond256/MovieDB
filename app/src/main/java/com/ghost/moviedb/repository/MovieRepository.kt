package com.ghost.moviedb.repository

import com.ghost.moviedb.model.PopularMovieApiModel
import com.ghost.moviedb.network.api.GetMovieApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import com.ghost.moviedb.base.Result
import com.ghost.moviedb.model.details.DetailsModelApi
import com.ghost.moviedb.model.videos.VideoModelApi
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

interface MovieRepository {
    suspend fun getPopularMovie(language: String?, page: Int): Flow<Result<PopularMovieApiModel>>
    suspend fun getMovieDetails(id: Int, language: String?): Flow<Result<DetailsModelApi>>
    suspend fun getVideosForMovie(id: Int, language: String?): Flow<Result<VideoModelApi>>
}

class MovieRepositoryImpl @Inject constructor(
    private val movieApi: GetMovieApi
) : MovieRepository {

    override suspend fun getPopularMovie(
        language: String?,
        page: Int
    ): Flow<Result<PopularMovieApiModel>> {
        return flow {
            emit(Result.onLoading())
            try {
                val result = movieApi.getPopularMovies(null, 1).await()
                emit(Result.onSuccess(result))
            } catch (e: Exception) {
                emit(Result.onFailure(e))
            }
        }.flowOn(Dispatchers.IO)
    }

    override suspend fun getMovieDetails(
        id: Int,
        language: String?
    ): Flow<Result<DetailsModelApi>> {
        return flow {
            emit(Result.onLoading())
            try {
                val result = movieApi.getMovieDetails(id, language).await()
                emit(Result.onSuccess(result))
            } catch (e: Exception) {
                emit(Result.onFailure(e))
            }
        }.flowOn(Dispatchers.IO)
    }

    override suspend fun getVideosForMovie(
        id: Int,
        language: String?
    ): Flow<Result<VideoModelApi>> {
        return flow {
            emit(Result.onLoading())
            try {
                val result = movieApi.getMovieVideos(id, language).await()
                emit(Result.onSuccess(result))
            } catch (e: Exception) {
                emit(Result.onFailure(e))
            }
        }.flowOn(Dispatchers.IO)
    }
}