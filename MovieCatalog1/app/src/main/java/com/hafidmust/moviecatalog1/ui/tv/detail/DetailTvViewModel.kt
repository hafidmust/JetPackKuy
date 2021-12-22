package com.hafidmust.moviecatalog1.ui.tv.detail

import androidx.lifecycle.ViewModel
import com.hafidmust.moviecatalog1.data.tv.TvEntity
import com.hafidmust.moviecatalog1.utils.DataDummy

class DetailTvViewModel : ViewModel() {
    private lateinit var tvId : String

    fun setSelectedMovie(id : String){
        tvId = id
    }

    fun getTvs() : TvEntity{
        lateinit var tv : TvEntity
        val tvEntities = DataDummy.generateDumyTv()
        for (tvEntity in tvEntities){
            if (tvEntity.id == tvId){
                tv = tvEntity
            }
        }
        return tv
    }
}