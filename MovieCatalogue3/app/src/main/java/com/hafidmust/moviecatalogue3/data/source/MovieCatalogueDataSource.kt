package com.hafidmust.moviecatalogue3.data.source

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.hafidmust.moviecatalogue3.data.source.local.entity.DetailEntity
import com.hafidmust.moviecatalogue3.data.source.local.entity.MovieEntity
import com.hafidmust.moviecatalogue3.data.source.local.entity.TvShowEntity
import com.hafidmust.moviecatalogue3.vo.Resource


interface MovieCatalogueDataSource {
    fun getDiscoverMovies() : LiveData<Resource<PagedList<MovieEntity>>>
    fun getDetailMovie(movieId : Int) : LiveData<Resource<MovieEntity>>
    fun getDiscoverTv() : LiveData<Resource<PagedList<TvShowEntity>>>
    fun getDetailTvShow(tvId : Int) : LiveData<Resource<TvShowEntity>>
    fun setFavoriteMovie(movie: MovieEntity, state: Boolean)
    fun getFavoriteMovie(): LiveData<PagedList<MovieEntity>>
    fun setFavoriteTv(tv: TvShowEntity, state: Boolean)
    fun getFavoriteTv() : LiveData<PagedList<TvShowEntity>>
}