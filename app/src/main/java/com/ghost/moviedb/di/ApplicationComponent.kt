package com.ghost.moviedb.di

import com.ghost.moviedb.repository.MovieRepository
import com.ghost.moviedb.ui.ListOfMoviesFragment
import com.ghost.moviedb.ui.details.DetailsMovieFragment
import dagger.Component
import javax.inject.Singleton

@Component(modules = [NetworkModule::class, RepositoryModule::class, ViewModelModule::class])
@Singleton
interface ApplicationComponent {
    fun inject(fragment: ListOfMoviesFragment)
    fun inject(fragment: DetailsMovieFragment)
}