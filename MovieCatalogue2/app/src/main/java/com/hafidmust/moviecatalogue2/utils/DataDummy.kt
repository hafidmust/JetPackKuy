package com.hafidmust.moviecatalogue2.utils

import com.hafidmust.moviecatalogue2.data.source.remote.response.ResultsItem

object DataDummy {
    fun getRemoteMovies() : List<ResultsItem> {
        return listOf(
            ResultsItem(
                adult = false,
                backdropPath = "/1Rr5SrvHxMXHu5RjKpaMba8VTzi.jpg",
                genreIds = listOf(28,12,878),
                id = 634649,
                originalLanguage = "en",
                originalTitle = "Spider-Man= No Way Home",
                overview = "Peter Parker is unmasked and no longer able to separate his normal life from the high-stakes of being a super-hero. When he asks for help from Doctor Strange the stakes become even more dangerous, forcing him to discover what it truly means to be Spider-Man.",
                popularity = 10507.821,
                posterPath = "/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg",
                releaseDate = "2021-12-15",
                title = "Spider-Man= No Way Home",
                video = false,
                voteAverage = 8.4,
                voteCount = 2984
            )
        )
    }
}
