package com.ghost.moviedb.ui

import com.ghost.moviedb.repository.MovieRepository
import javax.inject.Inject

class ListOfMoviesViewModel @Inject constructor(
    private val movieRepository: MovieRepository
): BaseViewModel() {

}