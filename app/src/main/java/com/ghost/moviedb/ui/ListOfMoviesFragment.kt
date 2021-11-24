package com.ghost.moviedb.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.ghost.moviedb.R
import com.ghost.moviedb.base.Result
import com.ghost.moviedb.di.Application
import com.ghost.moviedb.repository.MovieRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class ListOfMoviesFragment: Fragment(R.layout.list_of_movies_fragment) {

    @Inject lateinit var movieRepository: MovieRepository
    @Inject lateinit var listOfMoviesViewModelFactory: ViewModelProvider.Factory

    private val listOfMoviesViewModel: ListOfMoviesViewModel by viewModels {
        listOfMoviesViewModelFactory
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireContext().applicationContext as Application).appComponent.inject(this)
        Log.d("qqq", "onViewCreated: $movieRepository")


        GlobalScope.launch {
            movieRepository.getPopularMovie(page = 1,language = null).collect {

                when(it) {
                     ->
                }
            }
        }
    }

}