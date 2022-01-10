package com.hafidmust.moviecatalogue3.ui.tv

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.hafidmust.moviecatalogue3.data.source.MovieCatalogueRepository
import com.hafidmust.moviecatalogue3.data.source.local.entity.TvShowEntity
import com.hafidmust.moviecatalogue3.utils.DataDummy
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TvViewModelTest {
    private lateinit var viewModel: TvViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieCatalogueRepository: MovieCatalogueRepository

    @Mock
    private lateinit var observer : Observer<List<TvShowEntity>>

    @Before
    fun setUp() {
        viewModel = TvViewModel(movieCatalogueRepository)
    }

    @Test
    fun getDiscoverTv() {
        val dummyTv = DataDummy.getTv()
        val tvs = MutableLiveData<List<TvShowEntity>>()
        tvs.value = dummyTv

        `when`(movieCatalogueRepository.getDiscoverTv()).thenReturn(tvs)
        val tvEntities = viewModel.getDiscoverTv().value
        verify(movieCatalogueRepository).getDiscoverTv()
        assertNotNull(tvEntities)
        assertEquals(1, tvEntities?.size)

        viewModel.getDiscoverTv().observeForever(observer)
        verify(observer).onChanged(dummyTv)
    }
}