package com.ghost.moviedb.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavGraph
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.ghost.moviedb.R
import com.ghost.moviedb.base.Result
import com.ghost.moviedb.base.recycler.MarginItemDecorator
import com.ghost.moviedb.databinding.ListOfMoviesFragmentBinding
import com.ghost.moviedb.di.Application
import com.ghost.moviedb.model.ItemFilm
import com.ghost.moviedb.model.mapApiToItem
import com.ghost.moviedb.repository.MovieRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class ListOfMoviesFragment : Fragment(R.layout.list_of_movies_fragment),
    ListOfFilmsAdapter.OnItemListener {

    @Inject
    lateinit var movieRepository: MovieRepository

    @Inject
    lateinit var listOfMoviesViewModelFactory: ViewModelProvider.Factory

    private val binding by viewBinding(ListOfMoviesFragmentBinding::bind)

    private val listOfMoviesViewModel: ListOfMoviesViewModel by viewModels {
        listOfMoviesViewModelFactory
    }

    private val adapter: ListOfFilmsAdapter by lazy { ListOfFilmsAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireContext().applicationContext as Application).appComponent.inject(this)

        initRecycler()
        listOfMoviesViewModel.loadData()

        viewLifecycleOwner.lifecycleScope.launchWhenCreated {
            listOfMoviesViewModel.result.collect { data ->
                when (data) {
                    is Result.onLoading -> Log.d("qqq", "loading: ")
                    is Result.onSuccess -> {
                        adapter.items = adapter.items.toMutableList().apply {
                            addAll(mapApiToItem(data.data.results))
                        }
                    }
                    is Result.onFailure -> Log.d("qqq", "failure: ${data.exception}")
                }
            }
        }
    }

    private fun initRecycler() {
        binding.recyclerOfFilms.layoutManager =
            GridLayoutManager(requireContext(), 2, RecyclerView.VERTICAL, false)
        binding.recyclerOfFilms.addItemDecoration(
            MarginItemDecorator(
                top = 16,
                bottom = 16,
                right = 16,
                left = 16
            )
        )
        binding.recyclerOfFilms.adapter = adapter
        adapter.setOnItemListener(this)
    }

    override fun onItemClick(item: ItemFilm) {
        findNavController().navigate(
            ListOfMoviesFragmentDirections.actionListOfMoviesFragmentToDetailsMovieFragment(
                item.id
            )
        )
    }

}