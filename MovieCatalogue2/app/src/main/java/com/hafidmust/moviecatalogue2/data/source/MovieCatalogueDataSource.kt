package com.hafidmust.moviecatalogue2.data.source

import androidx.lifecycle.LiveData
import com.hafidmust.moviecatalogue2.data.source.local.entity.DetailMovieEntity
import com.hafidmust.moviecatalogue2.data.source.local.entity.MovieEntity
import com.hafidmust.moviecatalogue2.data.source.local.entity.TvShowEntity


interface MovieCatalogueDataSource {
    fun getDiscoverMovies() : LiveData<List<MovieEntity>>
    fun getDetailMovie(MovieId : Int) : LiveData<DetailMovieEntity>
    fun getDiscoverTv() : LiveData<List<TvShowEntity>>
}