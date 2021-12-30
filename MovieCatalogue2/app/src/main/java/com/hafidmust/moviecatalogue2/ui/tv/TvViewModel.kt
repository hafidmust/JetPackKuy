package com.hafidmust.moviecatalogue2.ui.tv

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hafidmust.moviecatalogue2.data.source.MovieCatalogueRepository

class TvViewModel(private val movieCatalogueRepository: MovieCatalogueRepository) : ViewModel() {

    fun getDiscoverTv() = movieCatalogueRepository.getDiscoverTv()

}