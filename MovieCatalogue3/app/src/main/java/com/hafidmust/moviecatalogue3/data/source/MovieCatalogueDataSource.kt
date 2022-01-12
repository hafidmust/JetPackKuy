package com.hafidmust.moviecatalogue3.data.source

import androidx.lifecycle.LiveData
import com.hafidmust.moviecatalogue3.data.source.local.entity.DetailEntity
import com.hafidmust.moviecatalogue3.data.source.local.entity.MovieEntity
import com.hafidmust.moviecatalogue3.data.source.local.entity.TvShowEntity
import com.hafidmust.moviecatalogue3.vo.Resource


interface MovieCatalogueDataSource {
    fun getDiscoverMovies() : LiveData<Resource<List<MovieEntity>>>
    fun getDetailMovie(movieId : Int) : LiveData<Resource<MovieEntity>>
    fun getDiscoverTv() : LiveData<Resource<List<TvShowEntity>>>
    fun getDetailTvShow(tvId : Int) : LiveData<Resource<TvShowEntity>>
    fun setFavoriteMovie(movie: MovieEntity, state: Boolean)
    fun getFavoriteMovie(): LiveData<List<MovieEntity>>
    fun setFavoriteTv(tv: TvShowEntity, state: Boolean)
    fun getFavoriteTv() : LiveData<List<TvShowEntity>>
}