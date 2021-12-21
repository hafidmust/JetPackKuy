package com.hafidmust.moviecatalog1.utils

import com.hafidmust.moviecatalog1.R
import com.hafidmust.moviecatalog1.data.movie.MovieEntity
import com.hafidmust.moviecatalog1.data.tv.TvEntity

object DataDummy {
    fun generateDumyMovie(): List<MovieEntity> {
        val movies = ArrayList<MovieEntity>()
        movies.add(
            MovieEntity(
                id = "1",
                posterPath = R.drawable.poster_aquaman,
                originalTitle = "Aquaman",
                overview = "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne",
                voteAverage = 8.0,
                releaseDate = "12/26/2018",
                category = "Action, Adventure, Fantasy",
                duration = "2h 23m"
            )
        )
        movies.add(
            MovieEntity(
                id = "2",
                posterPath = R.drawable.poster_bohemian,
                originalTitle = "Bohemian Rhapsody",
                overview = "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                voteAverage = 8.0,
                releaseDate = "10/30/2018",
                category = "Music, Drama, History",
                duration = "2h 15m"
            )
        )

        movies.add(
            MovieEntity(
                id = "3",
                posterPath = R.drawable.poster_creed,
                originalTitle = "Creed II",
                overview = "Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life.",
                voteAverage = 8.0,
                releaseDate = "11/21/2018",
                category = "Drama",
                duration = "2h 10m"
            )
        )
        movies.add(
            MovieEntity(
                id = "4",
                posterPath = R.drawable.poster_glass,
                originalTitle = "Glass",
                overview = "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
                voteAverage = 8.0,
                releaseDate = "01/18/2019",
                category = "Thriller, Drama, Science Fiction",
                duration = "2h 9m",
            )
        )
        movies.add(
            MovieEntity(
                id = "5",
                posterPath = R.drawable.poster_how_to_train,
                originalTitle = "How to Train Your Dragon: The Hidden World",
                overview = "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
                voteAverage = 8.0,
                releaseDate = "01/09/2019",
                category = "Animation, Family, Adventure",
                duration = "1h 44m"
            )
        )
        movies.add(
            MovieEntity(
                id = "6",
                posterPath = R.drawable.poster_infinity_war,
                originalTitle = "Avengers: Infinity War",
                overview = "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                voteAverage = 8.0,
                releaseDate = "04/27/2018",
                category = "Adventure, Action, Science Fiction",
                duration = "2h 29m"
            )
        )
        movies.add(
            MovieEntity(
                id = "7",
                posterPath = R.drawable.poster_overlord,
                originalTitle = "Overlord",
                overview = "France, June 1944. On the eve of D-Day, some American paratroopers fall behind enemy lines after their aircraft crashes while on a mission to destroy a radio tower in a small village near the beaches of Normandy. After reaching their target, the surviving paratroopers realise that, in addition to fighting the Nazi troops that patrol the village, they also must fight against something else.",
                voteAverage = 8.0,
                releaseDate = "11/09/2018",
                category = "Horror, War,Science Fiction",
                duration = "1h 50m"
            )
        )
        movies.add(
            MovieEntity(
                id = "8",
                posterPath = R.drawable.poster_ralph,
                originalTitle = "Ralph Breaks the Internet",
                overview = "Video game bad guy Ralph and fellow misfit Vanellope von Schweetz must risk it all by traveling to the World Wide Web in search of a replacement part to save Vanellope's video game, Sugar Rush. In way over their heads, Ralph and Vanellope rely on the citizens of the internet — the netizens — to help navigate their way, including an entrepreneur named Yesss, who is the head algorithm and the heart and soul of trend-making site",
                voteAverage = 8.0,
                releaseDate = "11/21/2018",
                category = "Family, Animation, Comedy, Adventure",
                duration = "1h 52m"
            )
        )
        movies.add(
            MovieEntity(
                id = "9",
                posterPath = R.drawable.poster_robin_hood,
                originalTitle = "Robin Hood",
                overview = "A war-hardened Crusader and his Moorish commander mount an audacious revolt against the corrupt English crown.",
                voteAverage = 8.0,
                releaseDate = "11/21/2018",
                category = "Adventure, Action, Thriller",
                duration = "1h 56m"
            )
        )
        movies.add(
            MovieEntity(
                id = "10",
                posterPath = R.drawable.poster_spiderman,
                originalTitle = "Spider-Man: Into the Spider-Verse",
                overview = "Miles Morales is juggling his life between being a high school student and being a spider-man. When Wilson \"Kingpin\" Fisk uses a super collider, others from across the Spider-Verse are transported to this dimension.",
                voteAverage = 8.0,
                releaseDate = "12/14/2018",
                category = "Action, Adventure, Animation, Science Fiction, Comedy",
                duration = "1h 57m"
            )
        )
        return movies
    }

    fun generateDumyTv(): List<TvEntity> {
        val tvs = ArrayList<TvEntity>()
        tvs.add(
            TvEntity(
                id = "1",
                posterPath = R.drawable.poster_arrow,
                originalTitle = "",
                overview = "",
                voteAverage = 8.0
            )
        )
        tvs.add(
            TvEntity(
                id = "2",
                posterPath = R.drawable.poster_doom_patrol,
                originalTitle = "",
                overview = "",
                voteAverage = 8.0
            )
        )
        tvs.add(
            TvEntity(
                id = "3",
                posterPath = R.drawable.poster_dragon_ball,
                originalTitle = "",
                overview = "",
                voteAverage = 8.0
            )
        )
        tvs.add(
            TvEntity(
                id = "4",
                posterPath = R.drawable.poster_family_guy,
                originalTitle = "",
                overview = "",
                voteAverage = 8.0
            )
        )
        tvs.add(
            TvEntity(
                id = "5",
                posterPath = R.drawable.poster_flash,
                originalTitle = "",
                overview = "",
                voteAverage = 8.0
            )
        )
        tvs.add(
            TvEntity(
                id = "6",
                posterPath = R.drawable.poster_god,
                originalTitle = "",
                overview = "",
                voteAverage = 8.0
            )
        )
        tvs.add(
            TvEntity(
                id = "7",
                posterPath = R.drawable.poster_gotham,
                originalTitle = "",
                overview = "",
                voteAverage = 8.0
            )
        )
        tvs.add(
            TvEntity(
                id = "8",
                posterPath = R.drawable.poster_grey_anatomy,
                originalTitle = "",
                overview = "",
                voteAverage = 8.0
            )
        )
        tvs.add(
            TvEntity(
                id = "9",
                posterPath = R.drawable.poster_naruto_shipudden,
                originalTitle = "",
                overview = "",
                voteAverage = 8.0
            )
        )
        tvs.add(
            TvEntity(
                id = "10",
                posterPath = R.drawable.poster_the_umbrella,
                originalTitle = "",
                overview = "",
                voteAverage = 8.0
            )
        )

        return tvs
    }

}