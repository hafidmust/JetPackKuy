package com.hafidmust.moviecatalogue3.ui.favorite.ui.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.hafidmust.moviecatalogue3.data.source.MovieCatalogueRepository
import com.hafidmust.moviecatalogue3.data.source.local.entity.MovieEntity
import com.hafidmust.moviecatalogue3.utils.DataDummy
import com.hafidmust.moviecatalogue3.vo.Resource
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class FavMovieViewModelTest {
    private lateinit var viewModel: FavMovieViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieCatalogueRepository: MovieCatalogueRepository

    @Mock
    private lateinit var observer: Observer<PagedList<MovieEntity>>

    @Mock
    private lateinit var pagedList: PagedList<MovieEntity>

    @Before
    fun setUp() {
        viewModel = FavMovieViewModel(movieCatalogueRepository)
    }

    @Test
    fun getFavoriteMovies() {
        val dummyFavMovie = pagedList
        `when`(dummyFavMovie.size).thenReturn(1)
        val favMovies = MutableLiveData<PagedList<MovieEntity>>()
        favMovies.value = dummyFavMovie

        Mockito.`when`(movieCatalogueRepository.getFavoriteMovie()).thenReturn(favMovies)
        val entities = viewModel.getFavoriteMovies().value
        verify(movieCatalogueRepository).getFavoriteMovie()
        assertNotNull(favMovies)
        assertEquals(1, entities?.size)

        viewModel.getFavoriteMovies().observeForever(observer)
        verify(observer).onChanged(dummyFavMovie)
    }
}