package com.hafidmust.moviecatalogue2.ui.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.hafidmust.moviecatalogue2.data.source.local.MovieEntity
import com.hafidmust.moviecatalogue2.data.source.remote.response.ResultsItem
import com.hafidmust.moviecatalogue2.databinding.FragmentMovieBinding
import com.hafidmust.moviecatalogue2.viewmodel.ViewModelFactory

class MovieFragment : Fragment() {

    private lateinit var movieViewModel: MovieViewModel
    private lateinit var fragmentMovieBinding: FragmentMovieBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentMovieBinding = FragmentMovieBinding.inflate(layoutInflater, container, false)
        return fragmentMovieBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null){
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[MovieViewModel::class.java]
            val movieAdapter = MovieAdapter(object : MovieAdapter.ClickListener{
                override fun doClick(item: MovieEntity) {
//                    intent
                }
            })
            viewModel.getDiscoverMovies().observe(viewLifecycleOwner, {movies ->
                movieAdapter.setMovies(movies)
                movieAdapter.notifyDataSetChanged()
            })
            with(fragmentMovieBinding.rvMovie){
                layoutManager = GridLayoutManager(context,2)
                setHasFixedSize(true)
                adapter = movieAdapter
            }
        }
    }
}