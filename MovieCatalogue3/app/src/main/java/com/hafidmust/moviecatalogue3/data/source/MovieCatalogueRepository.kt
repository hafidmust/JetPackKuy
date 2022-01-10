package com.hafidmust.moviecatalogue3.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hafidmust.moviecatalogue3.data.source.local.entity.DetailEntity
import com.hafidmust.moviecatalogue3.data.source.local.entity.MovieEntity
import com.hafidmust.moviecatalogue3.data.source.local.entity.TvShowEntity
import com.hafidmust.moviecatalogue3.data.source.remote.RemoteDataSource
import com.hafidmust.moviecatalogue3.data.source.remote.response.DetailMovieResponse
import com.hafidmust.moviecatalogue3.data.source.remote.response.DetailTvShowResponse
import com.hafidmust.moviecatalogue3.data.source.remote.response.ResultsItem
import com.hafidmust.moviecatalogue3.data.source.remote.response.ResultsItemTv

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
    override fun getDiscoverTv(): LiveData<List<TvShowEntity>> {
        val result = MutableLiveData<List<TvShowEntity>>()
        remoteDataSource.getDiscoverTv(object : RemoteDataSource.LoadTvCallback{
            override fun onTvLoaded(tv: List<ResultsItemTv>?) {
                val tvList = ArrayList<TvShowEntity>()
                if (tv != null){
                    for (response in tv){
                        with(response){
                            val tvs = TvShowEntity(id, posterPath)
                            tvList.add(tvs)
                        }
                    }
                    result.postValue(tvList)
                }
            }
        })
        return result
    }

    override fun getDetailTvShow(tvId: Int): LiveData<DetailEntity> {
        val detailTv = MutableLiveData<DetailEntity>()
        remoteDataSource.getDetailTvShow(object : RemoteDataSource.LoadDetailTvShowCallback{
            override fun onDetailTvLoaded(detailTvShowResponse: DetailTvShowResponse) {
                with(detailTvShowResponse){
                    val detail = DetailEntity(idEntity = id,originalTitle = originalName,overview = overview,releaseDate = firstAirDate,voteAverage = voteAverage,posterPath = posterPath)
                    detailTv.postValue(detail)
                }
            }
        },tvId)
        return detailTv
    }

    override fun getDetailMovie(movieId: Int): LiveData<DetailEntity> {
        val detailResult = MutableLiveData<DetailEntity>()
        remoteDataSource.getDetailMovies(object : RemoteDataSource.LoadDetailMoviesCallback {
            override fun onDetailMovieLoaded(detailMovie: DetailMovieResponse?) {
                if (detailMovie != null) {
                    with(detailMovie){
                        val detail = DetailEntity(id,originalTitle, overview, releaseDate, voteAverage, posterPath)
                        detailResult.postValue(detail)
                    }
                }
            }
        },movieId)
        return detailResult
    }



}