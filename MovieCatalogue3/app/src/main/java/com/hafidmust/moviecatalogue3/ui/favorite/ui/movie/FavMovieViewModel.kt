package com.hafidmust.moviecatalogue3.ui.favorite.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.hafidmust.moviecatalogue3.data.source.MovieCatalogueRepository
import com.hafidmust.moviecatalogue3.data.source.local.entity.MovieEntity

class FavMovieViewModel(private val movieCatalogueRepository: MovieCatalogueRepository): ViewModel() {
    fun getFavoriteMovies() : LiveData<List<MovieEntity>> = movieCatalogueRepository.getFavoriteMovie()
}