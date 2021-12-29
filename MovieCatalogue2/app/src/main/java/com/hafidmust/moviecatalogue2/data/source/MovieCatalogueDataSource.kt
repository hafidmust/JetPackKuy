package com.hafidmust.moviecatalogue2.data.source

import androidx.lifecycle.LiveData
import com.hafidmust.moviecatalogue2.data.source.local.entity.DetailMovieEntity
import com.hafidmust.moviecatalogue2.data.source.local.entity.MovieEntity


interface MovieCatalogueDataSource {
    fun getDiscoverMovies() : LiveData<List<MovieEntity>>
    fun getDetailMovie(MovieId : Int) : LiveData<DetailMovieEntity>
}