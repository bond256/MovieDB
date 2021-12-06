package com.ghost.moviedb.ui.details

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.ghost.moviedb.R
import com.ghost.moviedb.base.Result
import com.ghost.moviedb.databinding.DetailsMovieFragmentBinding
import com.ghost.moviedb.di.Application
import com.ghost.moviedb.model.mapApiToItem
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import javax.inject.Inject

class DetailsMovieFragment : Fragment(R.layout.details_movie_fragment) {

    @Inject
    lateinit var detailsMovieProvider: ViewModelProvider.Factory

    private val detailsMovieViewModel: DetailsMovieViewModel by viewModels {
        detailsMovieProvider
    }

    private val binding: DetailsMovieFragmentBinding by viewBinding(DetailsMovieFragmentBinding::bind)

    private val args get() = navArgs<DetailsMovieFragmentArgs>().value

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireContext().applicationContext as Application).appComponent.inject(this)

        detailsMovieViewModel.loadDetails(args.id)
        detailsMovieViewModel.loadVideos(args.id)

        lifecycleScope.launch {

            repeatOnLifecycle(Lifecycle.State.STARTED) {
                detailsMovieViewModel.resultDetails.collect { data ->
                    when (data) {
                        is Result.onLoading -> Log.d("qqq", "loading: ")
                        is Result.onSuccess -> {
                            Log.d("qqq", "details: ${data.data.originalTitle} ")
                        }
                        is Result.onFailure -> Log.d("qqq", "failure: ${data.exception}")
                    }
                }

                detailsMovieViewModel.resultVideos.collect { data ->
                    when (data) {
                        is Result.onLoading -> Log.d("qqq", "loading: ")
                        is Result.onSuccess -> {
                            Log.d("qqq", "videos: ")
                        }
                        is Result.onFailure -> Log.d("qqq", "failure: ${data.exception}")
                    }
                }
            }
        }

    }
}