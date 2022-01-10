package com.hafidmust.moviecatalogue3.ui.movie

import androidx.lifecycle.ViewModel
import com.hafidmust.moviecatalogue3.data.source.MovieCatalogueRepository

class MovieViewModel(private val movieCatalogueRepository: MovieCatalogueRepository) : ViewModel() {

    fun getDiscoverMovies() = movieCatalogueRepository.getDiscoverMovies()
}