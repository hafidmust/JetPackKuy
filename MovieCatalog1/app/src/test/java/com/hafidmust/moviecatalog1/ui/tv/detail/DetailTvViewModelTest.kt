package com.hafidmust.moviecatalog1.ui.tv.detail

import com.hafidmust.moviecatalog1.utils.DataDummy
import org.junit.Assert.*

import org.junit.Before
import org.junit.Test

class DetailTvViewModelTest {

    private lateinit var viewModel: DetailTvViewModel
    private val dummyTv = DataDummy.generateDumyTv()[0]
    private val tvId = dummyTv.id

    @Before
    fun setUp() {
        viewModel = DetailTvViewModel()
        tvId?.let { viewModel.setSelectedMovie(it) }
    }

    @Test
    fun getTvs() {
        tvId?.let { viewModel.setSelectedMovie(id = it) }
        val tvEntity = viewModel.getTvs()
        assertNotNull(tvEntity)
        assertEquals(dummyTv.id, tvEntity.id)
        assertEquals(dummyTv.posterPath, tvEntity.posterPath)
        assertEquals(dummyTv.originalTitle, tvEntity.originalTitle)
        assertEquals(dummyTv.voteAverage, tvEntity.voteAverage)
        assertEquals(dummyTv.overview, tvEntity.overview)
        assertEquals(dummyTv.season, tvEntity.season)
        assertEquals(dummyTv.category, tvEntity.category)
    }
}