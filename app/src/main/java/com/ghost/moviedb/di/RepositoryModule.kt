package com.ghost.moviedb.di

import com.ghost.moviedb.repository.MovieRepository
import com.ghost.moviedb.repository.MovieRepositoryImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface RepositoryModule {

    @Singleton
    @Binds
    fun movieRepositoryBinds(movieRepositoryImpl: MovieRepositoryImpl): MovieRepository
}