package com.ghost.moviedb.di

import com.ghost.moviedb.repository.MovieRepository
import com.ghost.moviedb.ui.ListOfMoviesFragment
import dagger.Component

@Component(modules = [NetworkModule::class, MovieRepository::class, ViewModelModule::class])
interface ApplicationComponent {
    fun inject(fragment: ListOfMoviesFragment)
}