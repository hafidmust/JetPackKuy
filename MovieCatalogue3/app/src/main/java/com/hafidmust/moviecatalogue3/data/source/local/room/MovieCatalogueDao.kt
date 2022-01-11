package com.hafidmust.moviecatalogue3.data.source.local.room

import android.graphics.Movie
import androidx.lifecycle.LiveData
import androidx.room.*
import com.hafidmust.moviecatalogue3.data.source.local.entity.MovieEntity

@Dao
interface MovieCatalogueDao {

    @Query("SELECT * FROM movieentities")
    fun getMovies() : LiveData<List<MovieEntity>>

    @Query("SELECT * FROM movieentities where isFavorite = 1")
    fun getFavoriteMovies() : LiveData<List<MovieEntity>>

    @Query("SELECT * FROM movieentities where id = :id")
    fun getDetailMovies(id : Int) : LiveData<MovieEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies(movie : List<MovieEntity>)

    @Update
    fun updateMovies(movie : MovieEntity)




}