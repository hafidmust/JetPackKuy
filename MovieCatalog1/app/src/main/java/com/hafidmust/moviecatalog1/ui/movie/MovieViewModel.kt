package com.hafidmust.moviecatalog1.ui.movie

import androidx.lifecycle.ViewModel
import com.hafidmust.moviecatalog1.data.movie.MovieEntity
import com.hafidmust.moviecatalog1.utils.DataDummy

class MovieViewModel : ViewModel() {
    fun getMovies() : List<MovieEntity> = DataDummy.generateDumyMovie()
}