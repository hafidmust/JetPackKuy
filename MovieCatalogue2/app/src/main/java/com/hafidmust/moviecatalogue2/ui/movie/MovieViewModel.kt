package com.hafidmust.moviecatalogue2.ui.movie

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hafidmust.moviecatalogue2.network.ApiConfig
import com.hafidmust.moviecatalogue2.data.source.remote.response.MovieResponse
import com.hafidmust.moviecatalogue2.data.source.remote.response.ResultsItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieViewModel : ViewModel() {

    private val _dataMovie = MutableLiveData<List<ResultsItem>>()
    val dataMovie : LiveData<List<ResultsItem>> = _dataMovie

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    companion object{
        private const val TAG = "MovieViewModel"
        private const val API_KEY = "052a0efe01d590db2b8e3aac840d8a92"
        private const val PAGE = 1

    }
    init {
        showDiscoverMovie()
    }

    private fun showDiscoverMovie() {
        _isLoading.value = true
        val client = ApiConfig.getApiService().getDiscoverMovie(API_KEY, PAGE)
        client.enqueue(object : Callback<MovieResponse>{
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                _isLoading.value = false
                if (response.isSuccessful){
                    _dataMovie.value = response.body()?.results
                }else{
                    Log.e(TAG,"onFailure : ${response.message()}")
                }
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                _isLoading.value = false
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }
        })
    }
}