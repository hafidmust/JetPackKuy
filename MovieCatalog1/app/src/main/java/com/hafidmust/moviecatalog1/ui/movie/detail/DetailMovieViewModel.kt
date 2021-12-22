package com.hafidmust.moviecatalog1.ui.movie.detail

import androidx.lifecycle.ViewModel
import com.hafidmust.moviecatalog1.data.movie.MovieEntity
import com.hafidmust.moviecatalog1.utils.DataDummy

class DetailMovieViewModel : ViewModel() {
    private lateinit var movieId : String

    fun setSelectedMovie(id : String){
        movieId = id
    }

    fun getMovies() : MovieEntity{
        lateinit var movie :MovieEntity
        val movieEntities = DataDummy.generateDumyMovie()
        for(movieEntity in movieEntities){
            if (movieEntity.id == movieId){
                movie = movieEntity
            }
        }
        return movie
    }
}