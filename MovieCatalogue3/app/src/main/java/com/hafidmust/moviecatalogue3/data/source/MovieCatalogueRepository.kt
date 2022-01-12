package com.hafidmust.moviecatalogue3.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
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

    override fun getDiscoverMovies(): LiveData<Resource<PagedList<MovieEntity>>> {
        return object : NetworkBoundResource<PagedList<MovieEntity>, List<ResultsItem>>(appExecutors){
            override fun loadFromDB(): LiveData<PagedList<MovieEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getAllMovies(), config).build()
            }

            override fun shouldFetch(data: PagedList<MovieEntity>?): Boolean {
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
    override fun getDiscoverTv(): LiveData<Resource<PagedList<TvShowEntity>>> {
        return object : NetworkBoundResource<PagedList<TvShowEntity>, List<ResultsItemTv>>(appExecutors){
            override fun loadFromDB(): LiveData<PagedList<TvShowEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getAllTv(), config).build()
            }

            override fun shouldFetch(data: PagedList<TvShowEntity>?): Boolean {
                return data == null || data.isEmpty()
            }

            override fun createCall(): LiveData<ApiResponse<List<ResultsItemTv>>> {
                return remoteDataSource.getDiscoverTv()
            }

            override fun saveCallResult(data: List<ResultsItemTv>) {
                val tvList = ArrayList<TvShowEntity>()
                for (response in data){
                    val tv = TvShowEntity(
//                        response.id,response.posterPath,false
                        id = response.id,
                        posterPath = response.posterPath,
                        originalTitle = response.originalName,
                        overview = response.overview,
                        releaseDate = response.firstAirDate,
                        voteAverage = response.voteAverage,
                        isFavorite = false
                    )
                    tvList.add(tv)
                }
                localDataSource.insertTv(tvList)
            }
        }.asLiveData()
    }

    override fun getDetailTvShow(tvId: Int): LiveData<Resource<TvShowEntity>> {
        return object : NetworkBoundResource<TvShowEntity, DetailTvShowResponse>(appExecutors){
            override fun loadFromDB(): LiveData<TvShowEntity> {
                return localDataSource.getDetailTv(tvId)
            }

            override fun shouldFetch(data: TvShowEntity?): Boolean {
                return data == null && data?.id == 0
            }

            override fun createCall(): LiveData<ApiResponse<DetailTvShowResponse>> {
                return remoteDataSource.getDetailTvShow(tvId)
            }

            override fun saveCallResult(data: DetailTvShowResponse) {
                val detailTv = TvShowEntity(
                    id = data.id,
                    posterPath = data.posterPath,
                    originalTitle = data.originalName,
                    overview = data.overview,
                    releaseDate = data.firstAirDate,
                    voteAverage = data.voteAverage,
                    isFavorite = false
                )
                localDataSource.setFavoriteTv(detailTv, false)
            }
        }.asLiveData()
    }

    override fun setFavoriteMovie(movie: MovieEntity, state: Boolean) {
        appExecutors.diskIO().execute {
            localDataSource.setFavoriteMovie(movie,state)
        }
    }

    override fun getFavoriteMovie(): LiveData<PagedList<MovieEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getFavoriteMovies(), config).build()
    }

    override fun setFavoriteTv(tv: TvShowEntity, state: Boolean) {
        appExecutors.diskIO().execute {
            localDataSource.setFavoriteTv(tv,state)
        }
    }

    override fun getFavoriteTv(): LiveData<PagedList<TvShowEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getFavoriteTv(), config).build()
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