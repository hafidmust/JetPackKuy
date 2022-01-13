package com.hafidmust.moviecatalogue3.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.hafidmust.moviecatalogue3.data.source.local.LocalDataSource
import com.hafidmust.moviecatalogue3.data.source.local.entity.MovieEntity
import com.hafidmust.moviecatalogue3.data.source.local.entity.TvShowEntity
import com.hafidmust.moviecatalogue3.data.source.remote.RemoteDataSource
import com.hafidmust.moviecatalogue3.utils.AppExecutors
import com.hafidmust.moviecatalogue3.utils.DataDummy
import com.hafidmust.moviecatalogue3.utils.LiveDataTestUtil
import com.hafidmust.moviecatalogue3.utils.PagedListUtil
import com.hafidmust.moviecatalogue3.vo.Resource
import com.nhaarman.mockitokotlin2.*
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.`when`
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
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getAllMovies("NEWEST")).thenReturn(dataSourceFactory)
        movieCatalogueRepository.getDiscoverMovies("NEWEST")

        val movieEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.getMovie()))
        verify(local).getAllMovies("NEWEST")
        assertNotNull(movieEntities.data)
        assertEquals(moviesResponse.size, movieEntities.data?.size)
    }

    @Test
    fun getDiscoverTv() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowEntity>
        `when`(local.getAllTv("NEWEST")).thenReturn(dataSourceFactory)
        movieCatalogueRepository.getDiscoverTv("NEWEST")

        val tvEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.getTv()))
        verify(local).getAllTv("NEWEST")
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
    @Test
    fun getFavMovie(){
        val dataSource = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getFavoriteMovies()).thenReturn(dataSource)
        movieCatalogueRepository.getFavoriteMovie()

        val entites = Resource.success(PagedListUtil.mockPagedList(DataDummy.getFavMovie()))
        verify(local).getFavoriteMovies()
        assertNotNull(entites)
        assertEquals(moviesResponse.size, entites.data?.size)
    }
    @Test
    fun getFavTv(){
        val dataSource = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowEntity>
        `when`(local.getFavoriteTv()).thenReturn(dataSource)
        movieCatalogueRepository.getFavoriteTv()

        val entites = Resource.success(PagedListUtil.mockPagedList(DataDummy.getFavTv()))
        verify(local).getFavoriteTv()
        assertNotNull(entites)
        assertEquals(tvResponse.size, entites.data?.size)
    }
    @Test
    fun setFavMovie(){
        movieCatalogueRepository.setFavoriteMovie(DataDummy.getDetailMovie(), true)
        verify(local).setFavoriteMovie(DataDummy.getDetailMovie(), true)
        verifyNoMoreInteractions(local)
    }
    @Test
    fun setFavTv(){
        movieCatalogueRepository.setFavoriteTv(DataDummy.getDetailTv(), true)
        verify(local).setFavoriteTv(DataDummy.getDetailTv(), true)
        verifyNoMoreInteractions(local)
    }


}