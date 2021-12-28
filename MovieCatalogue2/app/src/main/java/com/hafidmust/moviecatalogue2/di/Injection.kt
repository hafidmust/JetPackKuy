package com.hafidmust.moviecatalogue2.di

import android.content.Context
import com.hafidmust.moviecatalogue2.data.source.MovieCatalogueRepository
import com.hafidmust.moviecatalogue2.data.source.remote.RemoteDataSource

object Injection {
    fun provideRepository(context : Context) : MovieCatalogueRepository{
        val remoteDataSource = RemoteDataSource.getInstance()
        return MovieCatalogueRepository.getInstance(remoteDataSource)
    }
}