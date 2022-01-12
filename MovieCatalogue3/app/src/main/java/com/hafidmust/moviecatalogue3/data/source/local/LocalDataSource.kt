package com.hafidmust.moviecatalogue3.data.source.local

import androidx.lifecycle.LiveData
import com.hafidmust.moviecatalogue3.data.source.local.entity.MovieEntity
import com.hafidmust.moviecatalogue3.data.source.local.entity.TvShowEntity
import com.hafidmust.moviecatalogue3.data.source.local.room.MovieCatalogueDao

class LocalDataSource private constructor(private val movieCatalogueDao: MovieCatalogueDao) {

    fun getAllMovies() : LiveData<List<MovieEntity>> = movieCatalogueDao.getMovies()

    fun getFavoriteMovies() : LiveData<List<MovieEntity>> = movieCatalogueDao.getFavoriteMovies()

    fun getDetailMovies(id : Int) : LiveData<MovieEntity> = movieCatalogueDao.getDetailMovies(id)

    fun insertMovies(movie : List<MovieEntity>) = movieCatalogueDao.insertMovies(movie)

    fun setFavoriteMovie(movieEntity: MovieEntity, newState : Boolean){
        movieEntity.isFavorite = newState
        movieCatalogueDao.updateMovies(movieEntity)
    }

    fun getAllTv(): LiveData<List<TvShowEntity>> = movieCatalogueDao.getTvShow()

    fun getFavoriteTv() : LiveData<List<TvShowEntity>> = movieCatalogueDao.getFavoriteTv()

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
