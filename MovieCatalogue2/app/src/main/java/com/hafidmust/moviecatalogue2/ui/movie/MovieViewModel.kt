package com.hafidmust.moviecatalogue2.ui.movie

import androidx.lifecycle.ViewModel
import com.hafidmust.moviecatalogue2.data.source.MovieCatalogueRepository

class MovieViewModel(private val movieCatalogueRepository: MovieCatalogueRepository) : ViewModel() {

    fun getDiscoverMovies() = movieCatalogueRepository.getDiscoverMovies()
}