package com.hafidmust.moviecatalogue3.ui.movie

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.hafidmust.moviecatalogue3.data.source.local.entity.MovieEntity
import com.hafidmust.moviecatalogue3.databinding.FragmentMovieBinding
import com.hafidmust.moviecatalogue3.ui.detail.DetailActivity
import com.hafidmust.moviecatalogue3.viewmodel.ViewModelFactory
import com.hafidmust.moviecatalogue3.vo.Status

class MovieFragment : Fragment() {

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
                    val intent = Intent(
                        activity, DetailActivity::class.java
                    ).apply {
                        putExtra(DetailActivity.EXTRA_ID, item.id)
                        putExtra(DetailActivity.EXTRA_TYPE, "movie")
                    }
                    startActivity(intent)
                }
            })
            viewModel.getDiscoverMovies().observe(viewLifecycleOwner, {movies ->
                if(movies !=null){
                    when(movies.status){
                        Status.LOADING -> fragmentMovieBinding.progressBar.visibility = View.VISIBLE
                        Status.SUCCESS -> {
                            fragmentMovieBinding.progressBar.visibility = View.GONE
                            movieAdapter.submitList(movies.data)
                        }
                        Status.ERROR->{
                            Toast.makeText(context, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })
            with(fragmentMovieBinding.rvMovie){
                layoutManager = GridLayoutManager(context,2)
                setHasFixedSize(true)
                adapter = movieAdapter
            }
        }
    }
}