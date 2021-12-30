package com.hafidmust.moviecatalogue2.data.source.remote

import android.util.Log
import com.hafidmust.moviecatalogue2.BuildConfig
import com.hafidmust.moviecatalogue2.data.source.remote.response.*
import com.hafidmust.moviecatalogue2.network.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource {
    companion object{
        @Volatile
        private var instance : RemoteDataSource? = null

        fun getInstance() : RemoteDataSource =
            instance ?: synchronized(this){
                instance ?: RemoteDataSource()
            }
    }

    fun getDiscoverMovies(callback : LoadMoviesCallback){
        val client = ApiConfig.getApiService().getDiscoverMovie(BuildConfig.API_KEY,1)
        client.enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                callback.onMoviesLoaded(response.body()?.results)
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Log.e("RemoteDataSource","getDiscoverMovies ${t.message}")
            }
        })
    }

    fun getDiscoverTv(callback : LoadTvCallback){
        val client = ApiConfig.getApiService().getDiscoverTv(BuildConfig.API_KEY,1)
        client.enqueue(object : Callback<TvShowResponse>{
            override fun onResponse(
                call: Call<TvShowResponse>,
                response: Response<TvShowResponse>
            ) {
                callback.onTvLoaded(response.body()?.results)
            }

            override fun onFailure(call: Call<TvShowResponse>, t: Throwable) {
                Log.e("RemoteDataSource","getDiscoverTv : ${t.message}")
            }
        })
    }



    fun getDetailMovies(callback : LoadDetailMoviesCallback, movieId : Int){
        val client = ApiConfig.getApiService().getDetailMovie(movieId, BuildConfig.API_KEY)
        client.enqueue(object : Callback<DetailMovieResponse>{
            override fun onResponse(
                call: Call<DetailMovieResponse>,
                response: Response<DetailMovieResponse>
            ) {
                callback.onDetailMovieLoaded(response.body())
            }

            override fun onFailure(call: Call<DetailMovieResponse>, t: Throwable) {
                Log.e("RemoteDataSource","getDetailMovies ${t.message}")
            }
        })

    }

    interface LoadDetailMoviesCallback {
        fun onDetailMovieLoaded(detailMovie : DetailMovieResponse?)
    }

    interface LoadMoviesCallback {
        fun onMoviesLoaded(movies : List<ResultsItem>?)
    }

    interface LoadTvCallback {
        fun onTvLoaded(tv : List<ResultsItemTv>?)
    }
}


