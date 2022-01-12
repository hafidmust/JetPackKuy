package com.hafidmust.moviecatalogue3.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.hafidmust.moviecatalogue3.data.source.local.LocalDataSource
import com.hafidmust.moviecatalogue3.data.source.local.entity.MovieEntity
import com.hafidmust.moviecatalogue3.data.source.local.entity.TvShowEntity
import com.hafidmust.moviecatalogue3.data.source.remote.RemoteDataSource
import com.hafidmust.moviecatalogue3.utils.AppExecutors
import com.hafidmust.moviecatalogue3.utils.DataDummy
import com.hafidmust.moviecatalogue3.utils.LiveDataTestUtil
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.mock

class MovieCatalogueRepositoryTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()
    private val remote = mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val appExecutors = mock(AppExecutors::class.java)
    private val movieCatalogueRepository = FakeMovieCatalogueRepository(remote, local, appExecutors)
    private val moviesResponse = DataDummy.getRemoteMovies()
    private val moviesDetailResponse = DataDummy.getRemoteDetailMovies()
    private val movieId = moviesResponse[0].id
    private val tvResponse = DataDummy.getRemoteTvShow()
    private val tvDetailResponse = DataDummy.getRemoteDetailTv()
    private val tvId = tvResponse[0].id




    @Test
    fun getDiscoverMovies() {
        val dummyMovies = MutableLiveData<List<MovieEntity>>()
        dummyMovies.value = DataDummy.getMovie()
        Mockito.`when`(local.getAllMovies()).thenReturn(dummyMovies)
        val movieEntities = LiveDataTestUtil.getValue(movieCatalogueRepository.getDiscoverMovies())
        verify(local).getAllMovies()
        assertNotNull(movieEntities.data)
        assertEquals(moviesResponse.size, movieEntities.data?.size)
    }

    @Test
    fun getDiscoverTv() {
        val dummyTv = MutableLiveData<List<TvShowEntity>>()
        dummyTv.value = DataDummy.getTv()
        Mockito.`when`(local.getAllTv()).thenReturn(dummyTv)

        val tvEntities = LiveDataTestUtil.getValue(movieCatalogueRepository.getDiscoverTv())
        verify(local).getAllTv()
        assertNotNull(tvEntities.data)
        assertEquals(tvResponse.size, tvEntities.data?.size)
    }

    @Test
    fun getDetailTvShow() {
        val dummyDetail = MutableLiveData<TvShowEntity>()
        dummyDetail.value = DataDummy.getDetailTv()
        Mockito.`when`(local.getDetailTv(tvId)).thenReturn(dummyDetail)

        val tvDetailEntities = LiveDataTestUtil.getValue(movieCatalogueRepository.getDetailTvShow(tvId))
        verify(local).getDetailTv(tvId)
        assertNotNull(tvDetailEntities)
        assertEquals(tvDetailResponse.id, tvDetailEntities.data?.id)
    }

    @Test
    fun getDetailMovie() {
        val dummyDetail = MutableLiveData<MovieEntity>()
        dummyDetail.value = DataDummy.getDetailMovie()
        Mockito.`when`(local.getDetailMovies(movieId)).thenReturn(dummyDetail)

        val movieDetailEntities = LiveDataTestUtil.getValue(movieCatalogueRepository.getDetailMovie(movieId))
        verify(local).getDetailMovies(movieId)
        assertNotNull(movieDetailEntities)
        assertEquals(moviesDetailResponse.id, movieDetailEntities.data?.id)
    }
}