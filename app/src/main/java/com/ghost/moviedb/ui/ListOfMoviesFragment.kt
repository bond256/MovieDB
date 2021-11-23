package com.ghost.moviedb.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ghost.moviedb.R
import com.ghost.moviedb.di.Application
import javax.inject.Inject

class ListOfMoviesFragment: Fragment(R.layout.list_of_movies_fragment) {

    @Inject lateinit var

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireContext().applicationContext as Application).appComponent.inject(this)

    }

}