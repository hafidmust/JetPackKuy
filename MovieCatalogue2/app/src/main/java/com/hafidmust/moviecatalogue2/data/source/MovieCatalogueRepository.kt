package com.hafidmust.moviecatalogue2.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hafidmust.moviecatalogue2.data.source.local.entity.DetailMovieEntity
import com.hafidmust.moviecatalogue2.data.source.local.entity.MovieEntity
import com.hafidmust.moviecatalogue2.data.source.remote.RemoteDataSource
import com.hafidmust.moviecatalogue2.data.source.remote.response.DetailMovieResponse
import com.hafidmust.moviecatalogue2.data.source.remote.response.ResultsItem

class MovieCatalogueRepository private constructor(private val remoteDataSource: RemoteDataSource) :
    MovieCatalogueDataSource {
    companion object {
        @Volatile
        private var instance: MovieCatalogueRepository? = null
        fun getInstance(remoteData: RemoteDataSource): MovieCatalogueRepository =
            instance ?: synchronized(this) {
                instance ?: MovieCatalogueRepository(remoteData)
            }
    }

    override fun getDiscoverMovies(): LiveData<List<MovieEntity>> {
        val result = MutableLiveData<List<MovieEntity>>()
        remoteDataSource.getDiscoverMovies(object : RemoteDataSource.LoadMoviesCallback {
            override fun onMoviesLoaded(movies: List<ResultsItem>?) {
                val movieList = ArrayList<MovieEntity>()
                if (movies != null) {
                    for (response in movies) {
                        with(response) {
                            val movie = MovieEntity(id, posterPath)
                            movieList.add(movie)
                        }
                    }
                    result.postValue(movieList)
                }
            }
        })
        return result
    }

    override fun getDetailMovie(MovieId: Int): LiveData<DetailMovieEntity> {
        val detailResult = MutableLiveData<DetailMovieEntity>()
        remoteDataSource.getDetailMovies(object : RemoteDataSource.LoadDetailMoviesCallback {
            override fun onDetailMovieLoaded(detailMovie: DetailMovieResponse?) {
                if (detailMovie != null) {
                    with(detailMovie){
                        val detail = DetailMovieEntity(id,originalTitle, overview, releaseDate, voteAverage, posterPath)
                        detailResult.postValue(detail)
                    }
                }
            }
        },MovieId)
        return detailResult
    }
}