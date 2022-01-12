package com.hafidmust.moviecatalogue3.ui.favorite.ui.movie

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.hafidmust.moviecatalogue3.R
import com.hafidmust.moviecatalogue3.data.source.local.entity.MovieEntity
import com.hafidmust.moviecatalogue3.databinding.FragmentFavMovieBinding
import com.hafidmust.moviecatalogue3.ui.detail.DetailActivity
import com.hafidmust.moviecatalogue3.ui.movie.MovieAdapter
import com.hafidmust.moviecatalogue3.viewmodel.ViewModelFactory

class FavMovieFragment : Fragment() {
    private lateinit var binding: FragmentFavMovieBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFavMovieBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null){
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[FavMovieViewModel::class.java]
            val favMovieAdapter =  MovieAdapter(object : MovieAdapter.ClickListener{
                override fun doClick(item: MovieEntity) {
                    val intent = Intent(
                        activity, DetailActivity::class.java
                    ).apply {
                        putExtra(DetailActivity.EXTRA_ID, item.id)
                        putExtra(DetailActivity.EXTRA_TYPE, "movie")
                    }
                    startActivity(intent)
                }
            })

            viewModel.getFavoriteMovies().observe(viewLifecycleOwner,{favMovies->
                if (favMovies != null){
                    favMovieAdapter.setMovies(favMovies)
                    favMovieAdapter.notifyDataSetChanged()
                }
            })
            with(binding.rvFavoritemovie){
                layoutManager = GridLayoutManager(context, 2)
                setHasFixedSize(true)
                adapter = favMovieAdapter
            }
        }
    }

}