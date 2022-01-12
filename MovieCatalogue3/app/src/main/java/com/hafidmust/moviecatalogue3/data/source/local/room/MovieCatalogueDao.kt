package com.hafidmust.moviecatalogue3.data.source.local.room

import android.graphics.Movie
import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.hafidmust.moviecatalogue3.data.source.local.entity.MovieEntity
import com.hafidmust.moviecatalogue3.data.source.local.entity.TvShowEntity

@Dao
interface MovieCatalogueDao {

    @Query("SELECT * FROM movieentities")
    fun getMovies() : DataSource.Factory<Int, MovieEntity>

    @Query("SELECT * FROM movieentities where isFavorite = 1")
    fun getFavoriteMovies() : DataSource.Factory<Int, MovieEntity>

    @Query("SELECT * FROM movieentities where id = :id")
    fun getDetailMovies(id : Int) : LiveData<MovieEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies(movie : List<MovieEntity>)

    @Update
    fun updateMovies(movie : MovieEntity)

    @Query("SELECT * FROM tvshowentities")
    fun getTvShow(): DataSource.Factory<Int, TvShowEntity>

    @Query("SELECT * FROM tvshowentities where isFavorite = 1")
    fun getFavoriteTv(): DataSource.Factory<Int, TvShowEntity>

    @Query("SELECT * FROM tvshowentities where id = :id")
    fun getDetailTv(id: Int): LiveData<TvShowEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTv(tv: List<TvShowEntity>)

    @Update
    fun updateTv(tv: TvShowEntity)




}