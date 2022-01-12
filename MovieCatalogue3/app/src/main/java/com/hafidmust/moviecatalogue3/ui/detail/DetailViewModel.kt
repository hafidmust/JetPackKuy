package com.hafidmust.moviecatalogue3.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.hafidmust.moviecatalogue3.data.source.MovieCatalogueRepository
import com.hafidmust.moviecatalogue3.data.source.local.entity.DetailEntity
import com.hafidmust.moviecatalogue3.data.source.local.entity.MovieEntity
import com.hafidmust.moviecatalogue3.data.source.local.entity.TvShowEntity
import com.hafidmust.moviecatalogue3.vo.Resource

class DetailViewModel(private val movieCatalogueRepository: MovieCatalogueRepository) : ViewModel() {
    lateinit var setDataMovie : LiveData<Resource<MovieEntity>>
    lateinit var setDataTv : LiveData<Resource<TvShowEntity>>
    fun getData(id : Int, type : String){
        when(type){
            "movie" ->{
                setDataMovie = movieCatalogueRepository.getDetailMovie(id)
            }
            "tv" -> {
                setDataTv = movieCatalogueRepository.getDetailTvShow(id)
            }
        }
    }
    fun setFavMovie(){
        val movieResource = setDataMovie.value
        if (movieResource?.data != null){
            val newState = !movieResource.data.isFavorite
            movieCatalogueRepository.setFavoriteMovie(movieResource.data, newState)
        }
    }
    fun setFavTv(){
        val tvResource = setDataTv.value
        if (tvResource?.data != null){
            val newState = !tvResource.data.isFavorite
            movieCatalogueRepository.setFavoriteTv(tvResource.data, newState)
        }
    }

}