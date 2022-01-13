package com.hafidmust.moviecatalogue3.ui.tv

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.hafidmust.moviecatalogue3.data.source.MovieCatalogueRepository
import com.hafidmust.moviecatalogue3.data.source.local.entity.TvShowEntity
import com.hafidmust.moviecatalogue3.utils.DataDummy
import com.hafidmust.moviecatalogue3.vo.Resource
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
    private lateinit var observer : Observer<Resource<PagedList<TvShowEntity>>>

    @Mock
    private lateinit var pagedList: PagedList<TvShowEntity>

    @Before
    fun setUp() {
        viewModel = TvViewModel(movieCatalogueRepository)
    }

    @Test
    fun getDiscoverTv() {
        val dummyTv = Resource.success(pagedList)
        val tvs = MutableLiveData<Resource<PagedList<TvShowEntity>>>()
        tvs.value = dummyTv

        `when`(movieCatalogueRepository.getDiscoverTv("NEWEST")).thenReturn(tvs)
        val tvEntities = viewModel.getDiscoverTv("NEWEST").value?.data
        verify(movieCatalogueRepository).getDiscoverTv("NEWEST")
        assertNotNull(tvEntities)
        assertEquals(0, tvEntities?.size)

        viewModel.getDiscoverTv("NEWEST").observeForever(observer)
        verify(observer).onChanged(dummyTv)
    }
}