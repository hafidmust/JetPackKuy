package com.hafidmust.moviecatalogue2.ui.detail

import androidx.lifecycle.ViewModel
import com.hafidmust.moviecatalogue2.data.source.MovieCatalogueRepository

class DetailViewModel(private val movieCatalogueRepository: MovieCatalogueRepository) : ViewModel() {

    fun getDataMovies(id : Int) = movieCatalogueRepository.getDetailMovie(id)
}