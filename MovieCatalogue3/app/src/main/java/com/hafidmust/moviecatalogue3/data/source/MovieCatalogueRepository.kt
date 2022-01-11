package com.hafidmust.moviecatalogue3.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hafidmust.moviecatalogue3.NetworkBoundResource
import com.hafidmust.moviecatalogue3.data.source.local.LocalDataSource
import com.hafidmust.moviecatalogue3.data.source.local.entity.DetailEntity
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
                        response.id,response.posterPath,false
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

    override fun setFavoriteMovie(movie: MovieEntity, state: Boolean) {
        appExecutors.diskIO().execute {
            localDataSource.setFavoriteMovie(movie,state)
        }
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