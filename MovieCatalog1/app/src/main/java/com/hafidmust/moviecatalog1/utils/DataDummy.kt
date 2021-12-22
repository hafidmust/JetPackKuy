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
                originalTitle = "Arrow",
                overview = "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                season = "8 Season",
                category = "Crime, Drama, Mystery, Action & Adventure",
                duration = "42m",
                voteAverage = 8.0
            )
        )
        tvs.add(
            TvEntity(
                id = "2",
                posterPath = R.drawable.poster_doom_patrol,
                originalTitle = "Doom Patrol",
                overview = "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
                season = "3 Season",
                category = "Sci-Fi & Fantasy, Drama",
                duration = "49m",
                voteAverage = 8.0
            )
        )
        tvs.add(
            TvEntity(
                id = "3",
                posterPath = R.drawable.poster_dragon_ball,
                originalTitle = "Dragon Ball",
                overview = "Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the mystical Dragon Balls brought her to Goku's home. Together, they set off to find all seven and to grant her wish.",
                voteAverage = 8.0,
                season = "1 Season",
                category = "Animation, Action&Adventure, Sci-Fi&Fantasy",
                duration = "25m"
            )
        )
        tvs.add(
            TvEntity(
                id = "4",
                posterPath = R.drawable.poster_flash,
                originalTitle = "The Flash",
                overview = "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                voteAverage = 8.0,
                category = "Drama, Sci-Fi & Fantasy",
                season = "8 Season",
                duration = "44m"
            )
        )
        tvs.add(
            TvEntity(
                id = "5",
                posterPath = R.drawable.poster_family_guy,
                originalTitle = "Family Guy",
                overview = "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
                voteAverage = 8.0,
                season = "20 Season",
                category = "Animation, Comedy",
                duration = "22m"
            )
        )
        tvs.add(
            TvEntity(
                id = "6",
                posterPath = R.drawable.poster_god,
                originalTitle = "Game of Thrones",
                overview = "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
                voteAverage = 8.0,
                season = "8 Season",
                category = "Sci-Fi & Fantasy, Drama, Action & Adventure",
                duration = "1h"
            )
        )
        tvs.add(
            TvEntity(
                id = "7",
                posterPath = R.drawable.poster_gotham,
                originalTitle = "Gotham",
                overview = "Everyone knows the name Commissioner Gordon. He is one of the crime world's greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon's story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world's most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker?",
                voteAverage = 8.0,
                category = "Drama, Crime, Sci-Fi & Fantasy",
                duration = "43m",
                season = "5 Season"
            )
        )
        tvs.add(
            TvEntity(
                id = "8",
                posterPath = R.drawable.poster_grey_anatomy,
                originalTitle = "Greys Anatomy",
                overview = "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                voteAverage = 8.0,
                season = "18 Season",
                category = "Drama",
                duration = "43m"
            )
        )
        tvs.add(
            TvEntity(
                id = "9",
                posterPath = R.drawable.poster_naruto_shipudden,
                originalTitle = "Naruto Shippuden",
                overview = "Naruto Shippuuden is the continuation of the original animated TV series Naruto.The story revolves around an older and slightly more matured Uzumaki Naruto and his quest to save his friend Uchiha Sasuke from the grips of the snake-like Shinobi, Orochimaru. After 2 and a half years Naruto finally returns to his village of Konoha, and sets about putting his ambitions to work, though it will not be easy, as He has amassed a few (more dangerous) enemies, in the likes of the shinobi organization; Akatsuki.",
                voteAverage = 8.0,
                season = "20 Season",
                category = "Animation, Action & Adventure, Sci-Fi & Fantasy",
                duration = "25m"
            )
        )
        tvs.add(
            TvEntity(
                id = "10",
                posterPath = R.drawable.poster_the_umbrella,
                originalTitle = "The Umbrella Academy",
                overview = "A dysfunctional family of superheroes comes together to solve the mystery of their father's death, the threat of the apocalypse and more.",
                voteAverage = 8.0,
                season = "2 Season",
                category = "Action & Adventure, Sci-Fi & Fantasy, Drama",
                duration = "55m"
            )
        )

        return tvs
    }

}