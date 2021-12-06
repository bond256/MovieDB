package com.ghost.moviedb.ui

import androidx.lifecycle.ViewModel

abstract class BaseViewModel: ViewModel() {

    abstract fun loadData(page: Int = 0)
}