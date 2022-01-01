package com.hafidmust.moviecatalogue2.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.hafidmust.moviecatalogue2.data.source.remote.RemoteDataSource
import com.hafidmust.moviecatalogue2.utils.DataDummy
import com.hafidmust.moviecatalogue2.utils.LiveDataTestUtil
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.*
import org.junit.Rule

import org.junit.Test
import org.mockito.Mockito.mock

class MovieCatalogueRepositoryTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()
    private val remote = mock(RemoteDataSource::class.java)
    private val movieCatalogueRepository = FakeMovieCatalogueRepository(remote)
    private val moviesResponse = DataDummy.getRemoteMovies()




    @Test
    fun getDiscoverMovies() {
        doAnswer {
            (it.arguments[0] as RemoteDataSource.LoadMoviesCallback).onMoviesLoaded(moviesResponse)
            null
        }.`when`(remote).getDiscoverMovies(any())

        val movieEntities = LiveDataTestUtil.getValue(movieCatalogueRepository.getDiscoverMovies())
        verify(remote).getDiscoverMovies(any())
        assertNotNull(movieEntities)
        assertEquals(moviesResponse.size, movieEntities.size)
    }

    @Test
    fun getDiscoverTv() {

    }

    @Test
    fun getDetailTvShow() {
    }

    @Test
    fun getDetailMovie() {
    }
}