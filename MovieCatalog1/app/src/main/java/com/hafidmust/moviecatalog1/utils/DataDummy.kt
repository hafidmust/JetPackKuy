package com.hafidmust.moviecatalog1.utils

import com.hafidmust.moviecatalog1.data.movie.MovieEntity
import com.hafidmust.moviecatalog1.data.tv.TvEntity

object DataDummy {
    fun generateDumyMovie(): List<MovieEntity> {
        val movies = ArrayList<MovieEntity>()
        movies.add(
            MovieEntity(
                id = 1,
                posterPath = "",
                originalTitle = "",
                overview = "",
                voteAverage = 8.0
            )
        )
        return movies
    }
    fun generateDumyTv(): List<TvEntity> {
        val tvs = ArrayList<TvEntity>()
        tvs.add(
            TvEntity(
                id = 1,
                posterPath = "",
                originalTitle = "",
                overview = "",
                voteAverage = 8.0
            )
        )
        return tvs
    }

}