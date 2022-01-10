package com.hafidmust.moviecatalogue3.di

import android.content.Context
import com.hafidmust.moviecatalogue3.data.source.MovieCatalogueRepository
import com.hafidmust.moviecatalogue3.data.source.remote.RemoteDataSource

object Injection {
    fun provideRepository(context : Context) : MovieCatalogueRepository{
        val remoteDataSource = RemoteDataSource.getInstance()
        return MovieCatalogueRepository.getInstance(remoteDataSource)
    }
}