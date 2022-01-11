package com.hafidmust.moviecatalogue3.di

import android.content.Context
import com.hafidmust.moviecatalogue3.data.source.MovieCatalogueRepository
import com.hafidmust.moviecatalogue3.data.source.local.LocalDataSource
import com.hafidmust.moviecatalogue3.data.source.local.room.MovieCatalogueDatabase
import com.hafidmust.moviecatalogue3.data.source.remote.RemoteDataSource
import com.hafidmust.moviecatalogue3.utils.AppExecutors

object Injection {
    fun provideRepository(context : Context) : MovieCatalogueRepository{
        val database = MovieCatalogueDatabase.getInstance(context)
        val localDataSource = LocalDataSource.getInstance(database.moviecatalogueDao())
        val appExecutors = AppExecutors()
        val remoteDataSource = RemoteDataSource.getInstance()
        return MovieCatalogueRepository.getInstance(remoteDataSource,localDataSource,appExecutors)
    }
}