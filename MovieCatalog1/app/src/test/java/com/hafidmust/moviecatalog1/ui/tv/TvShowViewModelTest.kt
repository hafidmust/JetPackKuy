package com.hafidmust.moviecatalog1.ui.tv

import org.junit.Assert.*

import org.junit.Before
import org.junit.Test

class TvShowViewModelTest {
    private lateinit var viewModel: TvShowViewModel

    @Before
    fun setUp() {
        viewModel = TvShowViewModel()
    }

    @Test
    fun getTvs() {
        val tvEntities = viewModel.getTvs()
        assertNotNull(tvEntities)
        assertEquals(10, tvEntities.size)
    }
}