package com.ghost.moviedb.di

import com.ghost.moviedb.repository.MovieRepository
import com.ghost.moviedb.repository.MovieRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
interface RepositoryModule {

    @Binds
    fun movieRepositoryBinds(movieRepositoryImpl: MovieRepositoryImpl): MovieRepository
}