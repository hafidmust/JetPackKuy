package com.hafidmust.moviecatalogue2.network

import com.hafidmust.moviecatalogue2.data.source.remote.response.DetailMovieResponse
import com.hafidmust.moviecatalogue2.data.source.remote.response.DetailTvShowResponse
import com.hafidmust.moviecatalogue2.data.source.remote.response.MovieResponse
import com.hafidmust.moviecatalogue2.data.source.remote.response.TvShowResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("discover/movie")
    fun getDiscoverMovie(
        @Query("api_key") apiKey : String,
        @Query("page") page : Int
    ) : Call<MovieResponse>

    @GET("movie/{id}")
    fun getDetailMovie(
        @Path("id") id : Int,
        @Query("api_key") apiKey : String
    ) : Call<DetailMovieResponse>

    @GET("discover/tv")
    fun getDiscoverTv(
        @Query("api_key") apiKey : String,
        @Query("page") page : Int
    ) : Call<TvShowResponse>

    @GET("tv/{id}")
    fun getDetailTvShow(
        @Path("id") id : Int,
        @Query("api_key") apiKey : String
    ) : Call<DetailTvShowResponse>
}