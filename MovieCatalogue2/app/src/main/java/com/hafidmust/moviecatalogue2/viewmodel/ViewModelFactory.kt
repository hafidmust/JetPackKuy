package com.hafidmust.moviecatalogue2.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hafidmust.moviecatalogue2.data.source.MovieCatalogueRepository
import com.hafidmust.moviecatalogue2.di.Injection
import com.hafidmust.moviecatalogue2.ui.detail.DetailViewModel
import com.hafidmust.moviecatalogue2.ui.movie.MovieViewModel
import com.hafidmust.moviecatalogue2.ui.tv.TvViewModel

class ViewModelFactory private constructor(private val movieCatalogueRepository: MovieCatalogueRepository) : ViewModelProvider.NewInstanceFactory(){
    companion object{
        @Volatile
        private var instance : ViewModelFactory? = null

        fun getInstance(context : Context) : ViewModelFactory =
            instance ?: synchronized(this){
                instance ?: ViewModelFactory(Injection.provideRepository(context))
            }
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when{
            modelClass.isAssignableFrom(MovieViewModel::class.java)->{
                MovieViewModel(movieCatalogueRepository) as T
            }
            modelClass.isAssignableFrom(DetailViewModel::class.java)->{
                DetailViewModel(movieCatalogueRepository) as T
            }
            modelClass.isAssignableFrom(TvViewModel::class.java)->{
                TvViewModel(movieCatalogueRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel : "+modelClass.name)
        }

    }
}