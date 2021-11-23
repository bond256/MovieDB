package com.ghost.moviedb.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ghost.moviedb.ui.ListOfMoviesViewModel
import com.ghost.moviedb.ui.ViewModelFactory
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.multibindings.IntoMap
import kotlin.reflect.KClass

@Module
interface ViewModelModule {

    @Binds
   fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

   @Binds
   @IntoMap
   @ViewModelKey(ListOfMoviesViewModel::class)
   fun listOfMoviesViewModel(viewModel: ListOfMoviesViewModel): ViewModel

    @Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
    @kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
    @MapKey
    annotation class ViewModelKey(val value: KClass<out ViewModel>)
}