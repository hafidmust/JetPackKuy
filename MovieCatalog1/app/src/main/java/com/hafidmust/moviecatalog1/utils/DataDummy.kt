package com.hafidmust.moviecatalog1.utils

import com.hafidmust.moviecatalog1.R
import com.hafidmust.moviecatalog1.data.movie.MovieEntity
import com.hafidmust.moviecatalog1.data.tv.TvEntity

object DataDummy {
    fun generateDumyMovie(): List<MovieEntity> {
        val movies = ArrayList<MovieEntity>()
        movies.add(
            MovieEntity(
                id = 1,
                posterPath = R.drawable.poster_aquaman,
                originalTitle = "",
                overview = "",
                voteAverage = 8.0
            )
        )
        movies.add(
            MovieEntity(
                id = 2,
                posterPath = R.drawable.poster_bohemian,
                originalTitle = "",
                overview = "",
                voteAverage = 8.0
            )
        )

        movies.add(
            MovieEntity(
                id = 3,
                posterPath = R.drawable.poster_creed,
                originalTitle = "",
                overview = "",
                voteAverage = 8.0
            )
        )
        movies.add(
            MovieEntity(
                id = 4,
                posterPath = R.drawable.poster_glass,
                originalTitle = "",
                overview = "",
                voteAverage = 8.0
            )
        )
        movies.add(
            MovieEntity(
                id = 5,
                posterPath = R.drawable.poster_how_to_train,
                originalTitle = "",
                overview = "",
                voteAverage = 8.0
            )
        )
        movies.add(
            MovieEntity(
                id = 6,
                posterPath = R.drawable.poster_infinity_war,
                originalTitle = "",
                overview = "",
                voteAverage = 8.0
            )
        )
        movies.add(
            MovieEntity(
                id = 7,
                posterPath = R.drawable.poster_overlord,
                originalTitle = "",
                overview = "",
                voteAverage = 8.0
            )
        )
        movies.add(
            MovieEntity(
                id = 8,
                posterPath = R.drawable.poster_ralph,
                originalTitle = "",
                overview = "",
                voteAverage = 8.0
            )
        )
        movies.add(
            MovieEntity(
                id = 9,
                posterPath = R.drawable.poster_robin_hood,
                originalTitle = "",
                overview = "",
                voteAverage = 8.0
            )
        )
        movies.add(
            MovieEntity(
                id = 10,
                posterPath = R.drawable.poster_spiderman,
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
                posterPath = R.drawable.,
                originalTitle = "",
                overview = "",
                voteAverage = 8.0
            )
        )
        tvs.add(
            TvEntity(
                id = 1,
                posterPath = R.drawable.,
                originalTitle = "",
                overview = "",
                voteAverage = 8.0
            )
        )
        tvs.add(
            TvEntity(
                id = 1,
                posterPath = R.drawable.,
                originalTitle = "",
                overview = "",
                voteAverage = 8.0
            )
        )
        tvs.add(
            TvEntity(
                id = 1,
                posterPath = R.drawable.,
                originalTitle = "",
                overview = "",
                voteAverage = 8.0
            )
        )
        tvs.add(
            TvEntity(
                id = 1,
                posterPath = R.drawable.,
                originalTitle = "",
                overview = "",
                voteAverage = 8.0
            )
        )
        tvs.add(
            TvEntity(
                id = 1,
                posterPath = R.drawable.,
                originalTitle = "",
                overview = "",
                voteAverage = 8.0
            )
        )
        tvs.add(
            TvEntity(
                id = 1,
                posterPath = R.drawable.,
                originalTitle = "",
                overview = "",
                voteAverage = 8.0
            )
        )
        tvs.add(
            TvEntity(
                id = 1,
                posterPath = R.drawable.,
                originalTitle = "",
                overview = "",
                voteAverage = 8.0
            )
        )
        tvs.add(
            TvEntity(
                id = 1,
                posterPath = R.drawable.,
                originalTitle = "",
                overview = "",
                voteAverage = 8.0
            )
        )
        tvs.add(
            TvEntity(
                id = 1,
                posterPath = R.drawable.,
                originalTitle = "",
                overview = "",
                voteAverage = 8.0
            )
        )

        return tvs
    }

}