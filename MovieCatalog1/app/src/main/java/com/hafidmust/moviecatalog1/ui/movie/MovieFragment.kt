package com.hafidmust.moviecatalog1.ui.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.hafidmust.moviecatalog1.R
import com.hafidmust.moviecatalog1.databinding.FragmentMovieBinding
import com.hafidmust.moviecatalog1.ui.SectionsPagerAdapter
import com.hafidmust.moviecatalog1.utils.DataDummy

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MovieFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MovieFragment : Fragment() {

    private lateinit var binding : FragmentMovieBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

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
            val movies = DataDummy.generateDumyMovie()
            val movieAdapter =MovieAdapter()
            movieAdapter.setMovies(movies)

            with(binding.rvMovie){
                layoutManager = GridLayoutManager(context,2)
                setHasFixedSize(true)
                adapter = movieAdapter
            }
        }
    }

}