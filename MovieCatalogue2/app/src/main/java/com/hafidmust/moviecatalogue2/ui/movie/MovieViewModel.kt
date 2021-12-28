package com.hafidmust.moviecatalogue2.ui.movie

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hafidmust.moviecatalogue2.data.source.MovieCatalogueRepository
import com.hafidmust.moviecatalogue2.network.ApiConfig
import com.hafidmust.moviecatalogue2.data.source.remote.response.MovieResponse
import com.hafidmust.moviecatalogue2.data.source.remote.response.ResultsItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieViewModel(private val movieCatalogueRepository: MovieCatalogueRepository) : ViewModel() {

    fun getDiscoverMovies() = movieCatalogueRepository.getDiscoverMovies()
}