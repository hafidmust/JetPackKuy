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
                originalTitle = "Aquaman",
                overview = "lorem",
                voteAverage = 8.0
            )
        )
        movies.add(
            MovieEntity(
                id = 2,
                posterPath = R.drawable.poster_bohemian,
                originalTitle = "Bohemian",
                overview = "lorem",
                voteAverage = 8.0
            )
        )

        movies.add(
            MovieEntity(
                id = 3,
                posterPath = R.drawable.poster_creed,
                originalTitle = "Creed",
                overview = "lorem",
                voteAverage = 8.0
            )
        )
        movies.add(
            MovieEntity(
                id = 4,
                posterPath = R.drawable.poster_glass,
                originalTitle = "Glass",
                overview = "lorem",
                voteAverage = 8.0
            )
        )
        movies.add(
            MovieEntity(
                id = 5,
                posterPath = R.drawable.poster_how_to_train,
                originalTitle = "How to Train",
                overview = "lorem",
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
                originalTitle = "Overlord",
                overview = "lorem",
                voteAverage = 8.0
            )
        )
        movies.add(
            MovieEntity(
                id = 8,
                posterPath = R.drawable.poster_ralph,
                originalTitle = "Ralph",
                overview = "",
                voteAverage = 8.0
            )
        )
        movies.add(
            MovieEntity(
                id = 9,
                posterPath = R.drawable.poster_robin_hood,
                originalTitle = "Robin Hood",
                overview = "lorem",
                voteAverage = 8.0
            )
        )
        movies.add(
            MovieEntity(
                id = 10,
                posterPath = R.drawable.poster_spiderman,
                originalTitle = "Spiderman",
                overview = "lorem",
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
                posterPath = R.drawable.poster_arrow,
                originalTitle = "",
                overview = "",
                voteAverage = 8.0
            )
        )
        tvs.add(
            TvEntity(
                id = 1,
                posterPath = R.drawable.poster_doom_patrol,
                originalTitle = "",
                overview = "",
                voteAverage = 8.0
            )
        )
        tvs.add(
            TvEntity(
                id = 1,
                posterPath = R.drawable.poster_dragon_ball,
                originalTitle = "",
                overview = "",
                voteAverage = 8.0
            )
        )
        tvs.add(
            TvEntity(
                id = 1,
                posterPath = R.drawable.poster_family_guy,
                originalTitle = "",
                overview = "",
                voteAverage = 8.0
            )
        )
        tvs.add(
            TvEntity(
                id = 1,
                posterPath = R.drawable.poster_flash,
                originalTitle = "",
                overview = "",
                voteAverage = 8.0
            )
        )
        tvs.add(
            TvEntity(
                id = 1,
                posterPath = R.drawable.poster_god,
                originalTitle = "",
                overview = "",
                voteAverage = 8.0
            )
        )
        tvs.add(
            TvEntity(
                id = 1,
                posterPath = R.drawable.poster_gotham,
                originalTitle = "",
                overview = "",
                voteAverage = 8.0
            )
        )
        tvs.add(
            TvEntity(
                id = 1,
                posterPath = R.drawable.poster_grey_anatomy,
                originalTitle = "",
                overview = "",
                voteAverage = 8.0
            )
        )
        tvs.add(
            TvEntity(
                id = 1,
                posterPath = R.drawable.poster_naruto_shipudden,
                originalTitle = "",
                overview = "",
                voteAverage = 8.0
            )
        )
        tvs.add(
            TvEntity(
                id = 1,
                posterPath = R.drawable.poster_the_umbrella,
                originalTitle = "",
                overview = "",
                voteAverage = 8.0
            )
        )

        return tvs
    }

}