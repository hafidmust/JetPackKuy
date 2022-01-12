package com.hafidmust.moviecatalogue3.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.hafidmust.moviecatalogue3.data.source.MovieCatalogueRepository
import com.hafidmust.moviecatalogue3.data.source.local.entity.MovieEntity
import com.hafidmust.moviecatalogue3.vo.Resource

class MovieViewModel(private val movieCatalogueRepository: MovieCatalogueRepository) : ViewModel() {

    fun getDiscoverMovies(): LiveData<Resource<PagedList<MovieEntity>>> = movieCatalogueRepository.getDiscoverMovies()
}