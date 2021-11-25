package com.ghost.moviedb.ui

import androidx.lifecycle.viewModelScope
import com.ghost.moviedb.base.Result
import com.ghost.moviedb.model.PopularMovieApiModel
import com.ghost.moviedb.repository.MovieRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class ListOfMoviesViewModel @Inject constructor(
    private val movieRepository: MovieRepository
) : BaseViewModel() {

    private val _result = MutableStateFlow<Result<PopularMovieApiModel>>(Result.onLoading())
    val result: StateFlow<Result<PopularMovieApiModel>> get() = _result


    override fun loadData() {
        viewModelScope.launch {
            movieRepository.getPopularMovie(null, 1).collect {
                _result.value = it
            }
        }
    }





}