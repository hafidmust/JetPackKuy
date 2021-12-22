package com.hafidmust.moviecatalog1.ui.movie.detail

import com.hafidmust.moviecatalog1.utils.DataDummy
import org.junit.Assert.*

import org.junit.Before
import org.junit.Test

class DetailMovieViewModelTest {
    private lateinit var viewModel: DetailMovieViewModel
    private val dummyMovie = DataDummy.generateDumyMovie()[0]
    private val movieId = dummyMovie.id

    @Before
    fun setUp() {
        viewModel = DetailMovieViewModel()
        movieId?.let { viewModel.setSelectedMovie(it) }
    }

    @Test
    fun getMovies() {
        dummyMovie.id?.let { viewModel.setSelectedMovie(it) }
        val movieEntity = viewModel.getMovies()
        assertNotNull(movieEntity)
        assertEquals(dummyMovie.id, movieEntity.id)
        assertEquals(dummyMovie.posterPath, movieEntity.posterPath)
        assertEquals(dummyMovie.originalTitle, movieEntity.originalTitle)
        assertEquals(dummyMovie.overview, movieEntity.overview)
        assertEquals(dummyMovie.releaseDate, movieEntity.releaseDate)
        assertEquals(dummyMovie.category, movieEntity.category)
        assertEquals(dummyMovie.duration, movieEntity.duration)
    }
}