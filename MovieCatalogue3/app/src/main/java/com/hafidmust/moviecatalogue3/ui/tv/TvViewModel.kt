package com.hafidmust.moviecatalogue3.ui.tv

import androidx.lifecycle.ViewModel
import com.hafidmust.moviecatalogue3.data.source.MovieCatalogueRepository

class TvViewModel(private val movieCatalogueRepository: MovieCatalogueRepository) : ViewModel() {

    fun getDiscoverTv() = movieCatalogueRepository.getDiscoverTv()

}