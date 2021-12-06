package com.ghost.moviedb.ui.details

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.ghost.moviedb.base.Result
import com.ghost.moviedb.model.PopularMovieApiModel
import com.ghost.moviedb.model.details.DetailsModelApi
import com.ghost.moviedb.model.videos.VideoModelApi
import com.ghost.moviedb.repository.MovieRepository
import com.ghost.moviedb.ui.BaseViewModel
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

class DetailsMovieViewModel @Inject constructor(
 private val movieRepository: MovieRepository
): BaseViewModel() {

    private val _resultDetails = MutableStateFlow<Result<DetailsModelApi>>(Result.onLoading())
    val resultDetails: StateFlow<Result<DetailsModelApi>> get() = _resultDetails
    private val _resultVideos = MutableStateFlow<Result<VideoModelApi>>(Result.onLoading())
    val resultVideos: StateFlow<Result<VideoModelApi>> get() = _resultVideos


    fun loadDetails(id: Int) {
        viewModelScope.launch {
            movieRepository.getMovieDetails(id, null).collect {
                _resultDetails.value = it
            }
        }
    }

    fun loadVideos(id: Int) {
        viewModelScope.launch {
            movieRepository.getVideosForMovie(id, null).collect {
                _resultVideos.value = it
            }
        }
    }



    override fun loadData(page: Int) {
        TODO("Not yet implemented")
    }
}