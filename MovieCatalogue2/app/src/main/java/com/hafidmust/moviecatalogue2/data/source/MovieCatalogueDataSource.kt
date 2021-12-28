package com.hafidmust.moviecatalogue2.data.source

import androidx.lifecycle.LiveData
import com.hafidmust.moviecatalogue2.data.source.local.MovieEntity


interface MovieCatalogueDataSource {
    fun getDiscoverMovies() : LiveData<List<MovieEntity>>
}