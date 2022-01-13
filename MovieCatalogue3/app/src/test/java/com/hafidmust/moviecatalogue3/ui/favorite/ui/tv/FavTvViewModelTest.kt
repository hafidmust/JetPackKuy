package com.hafidmust.moviecatalogue3.ui.favorite.ui.tv

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.hafidmust.moviecatalogue3.data.source.FakeMovieCatalogueRepository
import com.hafidmust.moviecatalogue3.data.source.MovieCatalogueRepository
import com.hafidmust.moviecatalogue3.data.source.local.entity.MovieEntity
import com.hafidmust.moviecatalogue3.data.source.local.entity.TvShowEntity
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class FavTvViewModelTest {
    private lateinit var viewmodel: FavTvViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieCatalogueRepository: MovieCatalogueRepository

    @Mock
    private lateinit var observer: Observer<PagedList<TvShowEntity>>

    @Mock
    private lateinit var pagedList: PagedList<TvShowEntity>

    @Before
    fun setUp() {
        viewmodel = FavTvViewModel(movieCatalogueRepository)
    }

    @Test
    fun getFavoriteTv() {
        val dummyFavTv = pagedList
        `when`(dummyFavTv.size).thenReturn(1)
        val favTv = MutableLiveData<PagedList<TvShowEntity>>()
        favTv.value = dummyFavTv

        `when`(movieCatalogueRepository.getFavoriteTv()).thenReturn(favTv)
        val entites = viewmodel.getFavoriteTv().value
        verify(movieCatalogueRepository).getFavoriteTv()
        assertNotNull(favTv)
        assertEquals(1, entites?.size)

        viewmodel.getFavoriteTv().observeForever(observer)
        verify(observer).onChanged(dummyFavTv)
    }
}