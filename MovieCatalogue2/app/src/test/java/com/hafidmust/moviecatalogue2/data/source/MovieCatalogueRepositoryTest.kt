package com.hafidmust.moviecatalogue2.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.hafidmust.moviecatalogue2.data.source.remote.RemoteDataSource
import com.hafidmust.moviecatalogue2.utils.DataDummy
import com.hafidmust.moviecatalogue2.utils.LiveDataTestUtil
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock

class MovieCatalogueRepositoryTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()
    private val remote = mock(RemoteDataSource::class.java)
    private val movieCatalogueRepository = FakeMovieCatalogueRepository(remote)
    private val moviesResponse = DataDummy.getRemoteMovies()
    private val moviesDetailResponse = DataDummy.getRemoteDetailMovies()
    private val movieId = moviesResponse[0].id
    private val tvResponse = DataDummy.getRemoteTvShow()
    private val tvDetailResponse = DataDummy.getRemoteDetailTv()
    private val tvId = tvResponse[0].id




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
        doAnswer {
            (it.arguments[0] as RemoteDataSource.LoadTvCallback).onTvLoaded(tvResponse)
            null
        }.`when`(remote).getDiscoverTv(any())

        val tvEntities = LiveDataTestUtil.getValue(movieCatalogueRepository.getDiscoverTv())
        verify(remote).getDiscoverTv(any())
        assertNotNull(tvEntities)
        assertEquals(tvResponse.size, tvEntities.size)
    }

    @Test
    fun getDetailTvShow() {
        doAnswer {
            (it.arguments[0] as RemoteDataSource.LoadDetailTvShowCallback).onDetailTvLoaded(tvDetailResponse)
            null
        }.`when`(remote).getDetailTvShow(any(), eq(tvId))

        val tvDetailEntities = LiveDataTestUtil.getValue(movieCatalogueRepository.getDetailTvShow(tvId))
        verify(remote).getDetailTvShow(any(),eq(tvId))
        assertNotNull(tvDetailEntities)
        assertEquals(tvDetailResponse.id, tvDetailEntities.idEntity)
    }

    @Test
    fun getDetailMovie() {
        doAnswer {
            (it.arguments[0] as RemoteDataSource.LoadDetailMoviesCallback).onDetailMovieLoaded(moviesDetailResponse)
            null
        }.`when`(remote).getDetailMovies(any(), eq(movieId))

        val movieDetailEntities = LiveDataTestUtil.getValue(movieCatalogueRepository.getDetailMovie(movieId))
        verify(remote).getDetailMovies(any(),eq(movieId))
        assertNotNull(movieDetailEntities)
        assertEquals(moviesDetailResponse.id, movieDetailEntities.idEntity)
    }
}