package com.hafidmust.moviecatalogue3.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hafidmust.moviecatalogue3.NetworkBoundResource
import com.hafidmust.moviecatalogue3.data.source.local.LocalDataSource
import com.hafidmust.moviecatalogue3.data.source.local.entity.MovieEntity
import com.hafidmust.moviecatalogue3.data.source.local.entity.TvShowEntity
import com.hafidmust.moviecatalogue3.data.source.remote.ApiResponse
import com.hafidmust.moviecatalogue3.data.source.remote.RemoteDataSource
import com.hafidmust.moviecatalogue3.data.source.remote.response.*
import com.hafidmust.moviecatalogue3.utils.AppExecutors
import com.hafidmust.moviecatalogue3.vo.Resource

class MovieCatalogueRepository private constructor(private val remoteDataSource: RemoteDataSource,
private val localDataSource: LocalDataSource,
                                                   private val appExecutors: AppExecutors
                                                   ) :
    MovieCatalogueDataSource {
    companion object {
        @Volatile
        private var instance: MovieCatalogueRepository? = null
        fun getInstance(remoteData: RemoteDataSource, localDataSource: LocalDataSource, appExecutors: AppExecutors): MovieCatalogueRepository =
            instance ?: synchronized(this) {
                instance ?: MovieCatalogueRepository(remoteData, localDataSource, appExecutors)
            }
    }

    override fun getDiscoverMovies(): LiveData<Resource<List<MovieEntity>>> {
        return object : NetworkBoundResource<List<MovieEntity>, List<ResultsItem>>(appExecutors){
            override fun loadFromDB(): LiveData<List<MovieEntity>> {
                return localDataSource.getAllMovies()
            }

            override fun shouldFetch(data: List<MovieEntity>?): Boolean {
                return data == null || data.isEmpty()
            }

            override fun createCall(): LiveData<ApiResponse<List<ResultsItem>>> {
                return remoteDataSource.getDiscoverMovies()
            }

            override fun saveCallResult(data: List<ResultsItem>) {
                val movieList = ArrayList<MovieEntity>()
                for (response in data){
                    val movie = MovieEntity(
//                        response.id,response.posterPath,false
                    id = response.id,
                        posterPath = response.posterPath,
                        originalTitle = response.originalTitle,
                        overview = response.overview,
                        releaseDate = response.releaseDate,
                        voteAverage = response.voteAverage,
                        isFavorite = false
                    )
                    movieList.add(movie)
                }
                localDataSource.insertMovies(movieList)
            }
        }.asLiveData()
    }
    override fun getDiscoverTv(): LiveData<List<TvShowEntity>> {
        val result = MutableLiveData<List<TvShowEntity>>()
        remoteDataSource.getDiscoverTv(object : RemoteDataSource.LoadTvCallback{
            override fun onTvLoaded(tv: List<ResultsItemTv>?) {
                val tvList = ArrayList<TvShowEntity>()
                if (tv != null){
                    for (response in tv){
                        with(response){
                            val tvs = TvShowEntity(
                                id = id,
                                posterPath = posterPath,
                                originalTitle = originalName,
                                overview = overview,
                                releaseDate = firstAirDate,
                                voteAverage = voteAverage,
                                isFavorite = false
                            )
                            tvList.add(tvs)
                        }
                    }
                    result.postValue(tvList)
                }
            }
        })
        return result
    }

    override fun getDetailTvShow(tvId: Int): LiveData<TvShowEntity> {
        val detailTv = MutableLiveData<TvShowEntity>()
        remoteDataSource.getDetailTvShow(object : RemoteDataSource.LoadDetailTvShowCallback{
            override fun onDetailTvLoaded(detailTvShowResponse: DetailTvShowResponse) {
                with(detailTvShowResponse){
                    val detail = TvShowEntity(
                        id = id,
                        originalTitle = originalName,
                        overview = overview,
                        releaseDate = firstAirDate,
                        voteAverage = voteAverage,
                        posterPath = posterPath,
                        isFavorite = false)
                    detailTv.postValue(detail)
                }
            }
        },tvId)
        return detailTv
    }

    override fun setFavoriteMovie(movie: MovieEntity, state: Boolean) {
        appExecutors.diskIO().execute {
            localDataSource.setFavoriteMovie(movie,state)
        }
    }

    override fun getFavoriteMovie(): LiveData<List<MovieEntity>> {
        return localDataSource.getFavoriteMovies()
    }

    override fun getDetailMovie(movieId: Int): LiveData<Resource<MovieEntity>> {
        return object : NetworkBoundResource<MovieEntity, DetailMovieResponse>(appExecutors){
            override fun loadFromDB(): LiveData<MovieEntity> {
                return localDataSource.getDetailMovies(movieId)
            }

            override fun shouldFetch(data: MovieEntity?): Boolean {
                return data == null && data?.id == 0
            }

            override fun createCall(): LiveData<ApiResponse<DetailMovieResponse>> {
                return remoteDataSource.getDetailMovies(movieId)
            }

            override fun saveCallResult(data: DetailMovieResponse) {
                val detailMovie = MovieEntity(
                    id = data.id,
                    posterPath = data.posterPath,
                    originalTitle = data.originalTitle,
                    overview = data.overview,
                    releaseDate = data.releaseDate,
                    voteAverage = data.voteAverage,
                    isFavorite = false
                )
                localDataSource.setFavoriteMovie(detailMovie,false)
            }
        }.asLiveData()
    }



}