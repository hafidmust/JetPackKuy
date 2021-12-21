package com.hafidmust.moviecatalog1.ui.movie

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.hafidmust.moviecatalog1.R
import com.hafidmust.moviecatalog1.data.movie.MovieEntity
import com.hafidmust.moviecatalog1.databinding.FragmentMovieBinding
import com.hafidmust.moviecatalog1.ui.SectionsPagerAdapter
import com.hafidmust.moviecatalog1.ui.movie.detail.DetailMovieActivity
import com.hafidmust.moviecatalog1.utils.DataDummy

class MovieFragment : Fragment() {

    private lateinit var binding : FragmentMovieBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMovieBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(activity != null){
            val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[MovieViewModel::class.java]
            val movies = viewModel.getMovies()
            val movieAdapter =MovieAdapter(object : MovieAdapter.ClickListener{
                override fun doClick(item: MovieEntity) {
                    val intentSendId = Intent(
                        activity, DetailMovieActivity::class.java
                    ).apply {
                        putExtra(DetailMovieActivity.EXTRA_ID, item.id)
                    }
                    startActivity(intentSendId)
                }
            })
            movieAdapter.setMovies(movies)

            with(binding.rvMovie){
                layoutManager = GridLayoutManager(context,2)
                setHasFixedSize(true)
                adapter = movieAdapter
            }
        }
    }

}