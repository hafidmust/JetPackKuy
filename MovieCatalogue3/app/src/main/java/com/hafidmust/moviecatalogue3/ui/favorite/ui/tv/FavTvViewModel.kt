package com.hafidmust.moviecatalogue3.ui.favorite.ui.tv

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.hafidmust.moviecatalogue3.data.source.MovieCatalogueRepository
import com.hafidmust.moviecatalogue3.data.source.local.entity.TvShowEntity

class FavTvViewModel(private val movieCatalogueRepository: MovieCatalogueRepository) : ViewModel() {
    fun getFavoriteTv() : LiveData<PagedList<TvShowEntity>> = movieCatalogueRepository.getFavoriteTv()

}