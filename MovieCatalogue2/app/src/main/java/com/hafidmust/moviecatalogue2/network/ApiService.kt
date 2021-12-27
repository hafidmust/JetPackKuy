package com.hafidmust.moviecatalogue2.network

import com.hafidmust.moviecatalogue2.data.source.remote.response.MovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("movie")
    fun getDiscoverMovie(
        @Query("api_key") apiKey : String,
        @Query("page") page : Int
    ) : Call<MovieResponse>
}