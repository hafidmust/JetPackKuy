package com.hafidmust.moviecatalogue2.utils

import com.hafidmust.moviecatalogue2.data.source.remote.response.*

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
    fun getRemoteDetailMovies() : DetailMovieResponse{
        return DetailMovieResponse(
            adult = false,
            backdropPath = "/1Rr5SrvHxMXHu5RjKpaMba8VTzi.jpg",
            belongsToCollection = BelongsToCollection(
                id = 468552,
                name = "Wonder Woman Collection",
                posterPath = "/8AQRfTuTHeFTddZN4IUAqprN8Od.jpg",
                backdropPath = "/n9KlvCOBFDmSyw3BgNrkUkxMFva.jpg"
            ),
            budget = 200000000,
            genres = listOf(
                GenresItem(
                    id = 14,
                    name = "Fantasy"
                ),
                GenresItem(
                    id = 28,
                    name = "Action"
                ),
                GenresItem(
                    id = 12,
                    name = "Adventure"
                )
            ),
            homepage = "https://www.warnerbros.com/movies/wonder-woman-1984",
            id = 464052,
            imdbId = "tt7126948",
            originalLanguage = "en",
            originalTitle = "Wonder Woman 1984",
            overview = "Wonder Woman comes into conflict with the Soviet Union during the Cold War in the 1980s and finds a formidable foe by the name of the Cheetah.",
            popularity = 3342.686,
            posterPath = "/8UlWHLMpgZm9bx6QYh0NFoq67TZ.jpg",
            productionCompanies = listOf(
                ProductionCompaniesItem(
                    id = 9993,
                    logoPath = "/2Tc1P3Ac8M479naPp1kYT3izLS5.png",
                    name = "DC Entertainment",
                    originCountry = "US"
                ),
                ProductionCompaniesItem(
                    id = 174,
                    logoPath = "/ky0xOc5OrhzkZ1N6KyUxacfQsCk.png",
                    name = "Warner Bros. Pictures",
                    originCountry = "US"
                ),
                ProductionCompaniesItem(
                    id = 114152,
                    logoPath = "",
                    name = "The Stone Quarry",
                    originCountry = "US"
                ),
                ProductionCompaniesItem(
                    id = 128064,
                    logoPath = "/13F3Jf7EFAcREU0xzZqJnVnyGXu.png",
                    name = "DC Films",
                    originCountry = "US"
                ),
                ProductionCompaniesItem(
                    id = 507,
                    logoPath = "/z7H707qUWigbjHnJDMfj6QITEpb.png",
                    name = "Atlas Entertainment",
                    originCountry = "US"
                ),
                ProductionCompaniesItem(
                    id = 429,
                    logoPath = "/2Tc1P3Ac8M479naPp1kYT3izLS5.png",
                    name = "DC Comics",
                    originCountry = "US"
                )
            ),
            productionCountries = listOf(
                ProductionCountriesItem(
                    iso31661 = "US",
                    name = "United States of America"
                )
            ),
            releaseDate = "2020-12-16",
            revenue = 131400000,
            runtime = 151,
            spokenLanguages = listOf(
                SpokenLanguagesItem(
                    englishName = "English",
                    iso6391 = "en",
                    name = "English"
                )
            ),
            status = "Released",
            tagline = "A new era of wonder begins.",
            title = "Wonder Woman 1984",
            video = false,
            voteAverage = 7.2,
            voteCount = 2654
        )
    }
    fun getRemoteTvShow() : List<ResultsItemTv>{
        return listOf(
            ResultsItemTv(
                backdropPath = "/aq2yEMgRQBPfRkrO0Repo2qhUAT.jpg",
                firstAirDate = "2013-03-03",
                genreIds = listOf(10759, 18),
                id = 44217,
                name = "Vikings",
                originCountry = listOf("CA"),
                originalLanguage = "en",
                originalName = "Vikings",
                overview = "The adventures of Ragnar Lothbrok, the greatest hero of his age. The series tells the sagas of Ragnar's band of Viking brothers and his family, as he rises to become King of the Viking tribes. As well as being a fearless warrior, Ragnar embodies the Norse traditions of devotion to the gods. Legend has it that he was a direct descendant of Odin, the god of war and warriors.",
                popularity = 976.685,
                posterPath = "/bQLrHIRNEkE3PdIWQrZHynQZazu.jpg",
                voteAverage = 8.0,
                voteCount = 3794
            )
        )
    }
    fun getRemoteDetailTv() :  DetailTvShowResponse{
        return DetailTvShowResponse(
            backdropPath = "/gL8myjGc2qrmqVosyGm5CWTir9A.jpg",
            createdBy = listOf(
                CreatedByItem(
                    id = 68844,
                    creditId = "5ab47d649251417b020149ed",
                    name = "Hayden Schlossberg",
                    gender = 2,
                    profilePath = ""
                ),
                CreatedByItem(
                    id = 347335,
                    creditId = "5ab36c76c3a368615b004c6e",
                    name = "Josh Heald",
                    gender = 2,
                    profilePath = ""
                ),
                CreatedByItem(
                    id = 1801553,
                    creditId = "5ab47d690e0a265f24017c48",
                    name = "John Hurwitz",
                    gender = 2,
                    profilePath = ""
                )
            ),
            episodeRunTime = listOf(30),
            firstAirDate = "2018-05-02",
            genres = listOf(
                GenresItemTv(
                    id = 10759,
                    name = "Action & Adventure"
                ),
                GenresItemTv(
                    id = 18,
                    name = "Drama"
                )
            ),
            homepage = "https://www.netflix.com/title/81002370",
            id = 77169,
            inProduction = true,
            languages = listOf("en"),
            lastAirDate = "2021-01-01",
            lastEpisodeToAir = LastEpisodeToAir(
                airDate = "2021-01-01",
                episodeNumber = 10,
                id = 2529899,
                name = "December 19",
                overview = "Old wounds begin to heal at a country club holiday party, but a brutal assault by Kreese's students leads to new betrayals and alliances.",
                productionCode = "",
                seasonNumber = 3,
                stillPath = "/AvnkMnigxqapasWQCFpyXLPdxmG.jpg",
                voteAverage = 7.5,
                voteCount = 2
            ),
            name = "Cobra Kai",
            nextEpisodeToAir = "",
            networks = listOf(
                NetworksItem(
                    name = "Netflix",
                    id = 213,
                    logoPath = "/wwemzKWzjKYJFfCeiB57q3r4Bcm.png",
                    originCountry = ""
                ),
                NetworksItem(
                    name = "YouTube Premium",
                    id = 1436,
                    logoPath = "/3p05CgodUb9gPayuliuhawNj1Wo.png",
                    originCountry = "US"
                )
            ),
            numberOfEpisodes = 30,
            numberOfSeasons = 3,
            originCountry = listOf("US"),
            originalLanguage = "en",
            originalName = "Cobra Kai",
            overview = "This Karate Kid sequel series picks up 30 years after the events of the 1984 All Valley Karate Tournament and finds Johnny Lawrence on the hunt for redemption by reopening the infamous Cobra Kai karate dojo. This reignites his old rivalry with the successful Daniel LaRusso, who has been working to maintain the balance in his life without mentor Mr. Miyagi.",
            popularity = 1132.227,
            posterPath = "/obLBdhLxheKg8Li1qO11r2SwmYO.jpg",
            productionCompanies = listOf(
                ProductionCompaniesItemTv(
                    id = 101024,
                    logoPath = "",
                    name = "Hurwitz & Schlossberg Productions",
                    originCountry = "US"
                ),
                ProductionCompaniesItemTv(
                    id = 11073,
                    logoPath = "/wHs44fktdoj6c378ZbSWfzKsM2Z.png",
                    name = "Sony Pictures Television",
                    originCountry = "US"
                ),
                ProductionCompaniesItemTv(
                    id = 907,
                    logoPath = "/ca5SWI5uvU985f8Kbb4xc8AmVWH.png",
                    name = "Overbrook Entertainment",
                    originCountry = "US"
                ),
            ),
            productionCountries = listOf(
                ProductionCountriesItemTv(
                    iso31661 = "US",
                    name = "United States of America"
                )
            ),
            seasons = listOf(
                SeasonsItem(
                    airDate = "2018-05-02",
                    episodeCount = 10,
                    id = 99459,
                    name = "Season 1",
                    overview = "Decades after the tournament that changed their lives, the rivalry between Johnny and Daniel reignites.",
                    posterPath = "/lLrKXnM3WPEtrPCd1aTHT6x3hn.jpg",
                    seasonNumber = 1
                ),
                SeasonsItem(
                    airDate = "2019-04-24",
                    episodeCount = 10,
                    id = 120052,
                    name = "Season 2",
                    overview = "Johnny continues building a new life, but a face from his past could disrupt his future. Meanwhile, Daniel opens a Miyagi-Do studio to rival Cobra Kai.",
                    posterPath = "/77kyNXN6yCRjDt9eBMj96vLMx8W.jpg",
                    seasonNumber = 2
                ),
                SeasonsItem(
                    airDate = "2021-01-01",
                    episodeCount = 10,
                    id = 160283,
                    name = "Season 3",
                    overview = "With a new sensei at the helm of the Cobra Kai dojo, a three-way feud takes center stage. Old grudges — like Cobra Kai — never die.",
                    posterPath = "/5DfWqh360sjMxqj3Th3DZdnFk3I.jpg",
                    seasonNumber = 3
                )
            ),
            spokenLanguages = listOf(
                SpokenLanguagesItemTv(
                    englishName = "English",
                    iso6391 = "en",
                    name = "English"
                )
            ),
            status = "Returning Series",
            tagline = "Cobra Kai never dies.",
            type = "Scripted",
            voteAverage = 8.1,
            voteCount = 1724
        )
    }
}
