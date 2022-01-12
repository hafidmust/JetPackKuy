package com.hafidmust.moviecatalogue3.data.source.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hafidmust.moviecatalogue3.BuildConfig
import com.hafidmust.moviecatalogue3.data.source.local.entity.TvShowEntity
import com.hafidmust.moviecatalogue3.data.source.remote.response.*
import com.hafidmust.moviecatalogue3.network.ApiConfig
import com.hafidmust.moviecatalogue3.utils.EspressoIdlingResources
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource {


    fun getDiscoverMovies(): LiveData<ApiResponse<List<ResultsItem>>> {
        EspressoIdlingResources.increment()
        val resultMovie = MutableLiveData<ApiResponse<List<ResultsItem>>>()
        val client = ApiConfig.getApiService().getDiscoverMovie(BuildConfig.API_KEY,1)
        client.enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                resultMovie.value = ApiResponse.success(response.body()?.results as List<ResultsItem>)
                EspressoIdlingResources.decrement()
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Log.e("RemoteDataSource","getDiscoverMovies ${t.message}")
                EspressoIdlingResources.decrement()
            }
        })
        return resultMovie
    }

    fun getDiscoverTv(): LiveData<ApiResponse<List<ResultsItemTv>>>{
        EspressoIdlingResources.increment()
        val resultTv = MutableLiveData<ApiResponse<List<ResultsItemTv>>>()
        val client = ApiConfig.getApiService().getDiscoverTv(BuildConfig.API_KEY,1)
        client.enqueue(object : Callback<TvShowResponse>{
            override fun onResponse(
                call: Call<TvShowResponse>,
                response: Response<TvShowResponse>
            ) {
                resultTv.value = ApiResponse.success(response.body()?.results as List<ResultsItemTv>)
                EspressoIdlingResources.decrement()
            }

            override fun onFailure(call: Call<TvShowResponse>, t: Throwable) {
                Log.e("RemoteDataSource","getDiscoverTv : ${t.message}")
                EspressoIdlingResources.decrement()
            }
        })
        return resultTv
    }



    fun getDetailMovies(movieId : Int) : LiveData<ApiResponse<DetailMovieResponse>>{
        EspressoIdlingResources.increment()
        val resultDetailMovie = MutableLiveData<ApiResponse<DetailMovieResponse>>()
        val client = ApiConfig.getApiService().getDetailMovie(movieId, BuildConfig.API_KEY)
        client.enqueue(object : Callback<DetailMovieResponse>{
            override fun onResponse(
                call: Call<DetailMovieResponse>,
                response: Response<DetailMovieResponse>
            ) {
                resultDetailMovie.value = ApiResponse.success(response.body() as DetailMovieResponse)
                EspressoIdlingResources.decrement()
            }

            override fun onFailure(call: Call<DetailMovieResponse>, t: Throwable) {
                Log.e("RemoteDataSource","getDetailMovies ${t.message}")
                EspressoIdlingResources.decrement()
            }
        })
        return resultDetailMovie
    }
    fun getDetailTvShow(tvId : Int) : LiveData<ApiResponse<DetailTvShowResponse>>{
        EspressoIdlingResources.increment()
        val resultDetailTv = MutableLiveData<ApiResponse<DetailTvShowResponse>>()
        val client = ApiConfig.getApiService().getDetailTvShow(tvId, BuildConfig.API_KEY)
        client.enqueue(object : Callback<DetailTvShowResponse>{
            override fun onResponse(
                call: Call<DetailTvShowResponse>,
                response: Response<DetailTvShowResponse>
            ) {
                resultDetailTv.value = ApiResponse.success(response.body() as DetailTvShowResponse)
                EspressoIdlingResources.decrement()
            }

            override fun onFailure(call: Call<DetailTvShowResponse>, t: Throwable) {
                Log.e("RemoteDataSource","getDetailTv ${t.message}")
                EspressoIdlingResources.decrement()
            }
        })
        return resultDetailTv
    }
    interface LoadDetailTvShowCallback{
        fun onDetailTvLoaded(detailTvShowResponse: DetailTvShowResponse)
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
    companion object{
        @Volatile
        private var instance : RemoteDataSource? = null

        fun getInstance() : RemoteDataSource =
            instance ?: synchronized(this){
                instance ?: RemoteDataSource()
            }
    }
}


