package com.hafidmust.moviecatalogue3.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.hafidmust.moviecatalogue3.data.source.local.entity.MovieEntity
import com.hafidmust.moviecatalogue3.data.source.local.entity.TvShowEntity
import com.hafidmust.moviecatalogue3.data.source.local.room.MovieCatalogueDao
import com.hafidmust.moviecatalogue3.utils.Sortutils
import com.hafidmust.moviecatalogue3.utils.Sortutils.TABLE_MOVIE
import com.hafidmust.moviecatalogue3.utils.Sortutils.TABLE_TV

class LocalDataSource private constructor(private val movieCatalogueDao: MovieCatalogueDao) {

    fun getAllMovies(sort: String) : DataSource.Factory<Int, MovieEntity> = movieCatalogueDao.getMovies(Sortutils.getSortedQuery(sort,TABLE_MOVIE))

    fun getFavoriteMovies() : DataSource.Factory<Int, MovieEntity> = movieCatalogueDao.getFavoriteMovies()

    fun getDetailMovies(id : Int) : LiveData<MovieEntity> = movieCatalogueDao.getDetailMovies(id)

    fun insertMovies(movie : List<MovieEntity>) = movieCatalogueDao.insertMovies(movie)

    fun setFavoriteMovie(movieEntity: MovieEntity, newState : Boolean){
        movieEntity.isFavorite = newState
        movieCatalogueDao.updateMovies(movieEntity)
    }

    fun getAllTv(sort : String): DataSource.Factory<Int, TvShowEntity> = movieCatalogueDao.getTvShow(Sortutils.getSortedQuery(sort, TABLE_TV))

    fun getFavoriteTv() : DataSource.Factory<Int, TvShowEntity> = movieCatalogueDao.getFavoriteTv()

    fun getDetailTv(id: Int): LiveData<TvShowEntity> = movieCatalogueDao.getDetailTv(id)

    fun insertTv(tv: List<TvShowEntity>) = movieCatalogueDao.insertTv(tv)

    fun setFavoriteTv(tvShowEntity: TvShowEntity, newState: Boolean){
        tvShowEntity.isFavorite = newState
        movieCatalogueDao.updateTv(tvShowEntity)
    }


    companion object{
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(movieCatalogueDao: MovieCatalogueDao) : LocalDataSource =
            INSTANCE ?: LocalDataSource(movieCatalogueDao)
    }
}
