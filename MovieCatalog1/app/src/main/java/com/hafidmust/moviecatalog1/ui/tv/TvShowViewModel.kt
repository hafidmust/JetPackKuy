package com.hafidmust.moviecatalog1.ui.tv

import androidx.lifecycle.ViewModel
import com.hafidmust.moviecatalog1.data.tv.TvEntity
import com.hafidmust.moviecatalog1.utils.DataDummy

class TvShowViewModel : ViewModel() {
    fun getTvs() : List<TvEntity> = DataDummy.generateDumyTv()
}