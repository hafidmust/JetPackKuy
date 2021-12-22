package com.hafidmust.moviecatalog1.ui.movie

import org.junit.Assert.*

import org.junit.Before
import org.junit.Test

class MovieViewModelTest {
    private lateinit var viewModel: MovieViewModel

    @Before
    fun setUp() {
        viewModel = MovieViewModel()
    }

    @Test
    fun getMovies() {
        val movieEntities = viewModel.getMovies()
        assertNotNull(movieEntities)
        assertEquals(10, movieEntities.size)
    }
}