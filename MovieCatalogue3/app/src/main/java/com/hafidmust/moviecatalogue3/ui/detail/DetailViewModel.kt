package com.hafidmust.moviecatalogue3.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.hafidmust.moviecatalogue3.data.source.MovieCatalogueRepository
import com.hafidmust.moviecatalogue3.data.source.local.entity.DetailEntity

class DetailViewModel(private val movieCatalogueRepository: MovieCatalogueRepository) : ViewModel() {
    lateinit var setData : LiveData<DetailEntity>
    fun getData(id : Int, type : String): LiveData<DetailEntity>{
        when(type){
            "movie" ->{
                setData = movieCatalogueRepository.getDetailMovie(id)
            }
            "tv" -> {
                setData = movieCatalogueRepository.getDetailTvShow(id)
            }
        }
        return setData
    }

}