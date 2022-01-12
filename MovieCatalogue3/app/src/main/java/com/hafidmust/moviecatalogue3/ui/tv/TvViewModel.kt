package com.hafidmust.moviecatalogue3.ui.tv

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.hafidmust.moviecatalogue3.data.source.MovieCatalogueRepository
import com.hafidmust.moviecatalogue3.data.source.local.entity.TvShowEntity
import com.hafidmust.moviecatalogue3.vo.Resource

class TvViewModel(private val movieCatalogueRepository: MovieCatalogueRepository) : ViewModel() {

    fun getDiscoverTv(): LiveData<Resource<PagedList<TvShowEntity>>> = movieCatalogueRepository.getDiscoverTv()

}