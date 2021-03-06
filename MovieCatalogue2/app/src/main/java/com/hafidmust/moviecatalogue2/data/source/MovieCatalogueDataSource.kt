package com.hafidmust.moviecatalogue2.data.source

import androidx.lifecycle.LiveData
import com.hafidmust.moviecatalogue2.data.source.local.entity.DetailEntity
import com.hafidmust.moviecatalogue2.data.source.local.entity.MovieEntity
import com.hafidmust.moviecatalogue2.data.source.local.entity.TvShowEntity


interface MovieCatalogueDataSource {
    fun getDiscoverMovies() : LiveData<List<MovieEntity>>
    fun getDetailMovie(movieId : Int) : LiveData<DetailEntity>
    fun getDiscoverTv() : LiveData<List<TvShowEntity>>
    fun getDetailTvShow(tvId : Int) : LiveData<DetailEntity>
}