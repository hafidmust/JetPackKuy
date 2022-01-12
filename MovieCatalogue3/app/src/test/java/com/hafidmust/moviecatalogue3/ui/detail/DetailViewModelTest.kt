package com.hafidmust.moviecatalogue3.ui.detail

import android.graphics.Movie
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.hafidmust.moviecatalogue3.data.source.MovieCatalogueRepository
import com.hafidmust.moviecatalogue3.data.source.local.entity.DetailEntity
import com.hafidmust.moviecatalogue3.data.source.local.entity.MovieEntity
import com.hafidmust.moviecatalogue3.data.source.local.entity.TvShowEntity
import com.hafidmust.moviecatalogue3.utils.DataDummy
import com.hafidmust.moviecatalogue3.vo.Resource
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.verifyNoMoreInteractions
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailViewModelTest {
    private lateinit var viewModel: DetailViewModel
    private val dummyDetailMovie = DataDummy.getDetailMovie()
    private val dummyDetailTv = DataDummy.getDetailTv()
    private val movieId = dummyDetailMovie.id
    private val tvId = dummyDetailTv.id

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieCatalogueRepository: MovieCatalogueRepository

    @Mock
    private lateinit var observerMovie : Observer<Resource<MovieEntity>>

    @Mock
    private lateinit var observerTv : Observer<Resource<TvShowEntity>>

    @Before
    fun setUp() {
        viewModel = DetailViewModel(movieCatalogueRepository)
    }

    @Test
    fun setFavMovie(){
        val dummyDetailMovie = Resource.success(DataDummy.getDetailMovie())
        val movie = MutableLiveData<Resource<MovieEntity>>()
        movie.value = dummyDetailMovie

        Mockito.`when`(movieCatalogueRepository.getDetailMovie(movieId)).thenReturn(movie)
        viewModel.getData(movieId, "movie")
        viewModel.setFavMovie()
        verify(movieCatalogueRepository).setFavoriteMovie(movie.value!!.data as MovieEntity, true)
        verifyNoMoreInteractions(observerMovie)

    }


    @Test
    fun getDataMovie() {
        val dummyDetailMovie = Resource.success(DataDummy.getDetailMovie())
        val dataMovie = MutableLiveData<Resource<MovieEntity>>()
        dataMovie.value = dummyDetailMovie

        `when`(movieCatalogueRepository.getDetailMovie(movieId)).thenReturn(dataMovie)
        viewModel.getData(movieId,"movie")
        val detailMovieEntities = viewModel.setDataMovie.value?.data as MovieEntity
        verify(movieCatalogueRepository).getDetailMovie(movieId)

        assertNotNull(detailMovieEntities)
        assertEquals(dummyDetailMovie.data?.id, detailMovieEntities.id)
        assertEquals(dummyDetailMovie.data?.originalTitle, detailMovieEntities.originalTitle)
        assertEquals(dummyDetailMovie.data?.overview, detailMovieEntities.overview)
        assertEquals(dummyDetailMovie.data?.releaseDate, detailMovieEntities.releaseDate)
        dummyDetailMovie.data?.voteAverage?.let { assertEquals(it, detailMovieEntities.voteAverage, 0.0001) }
        assertEquals(dummyDetailMovie.data?.posterPath, detailMovieEntities.posterPath)


        viewModel.setDataMovie.observeForever(observerMovie)
        verify(observerMovie).onChanged(dummyDetailMovie)
    }

    @Test
    fun getDataTv(){
        val dummyDetailTv = Resource.success(DataDummy.getDetailTv())
        val dataTv = MutableLiveData<Resource<TvShowEntity>>()
        dataTv.value = dummyDetailTv
        `when`(movieCatalogueRepository.getDetailTvShow(tvId)).thenReturn(dataTv)
        viewModel.getData(tvId, "tv")
        val detailTvEntities = viewModel.setDataTv.value?.data as TvShowEntity
        verify(movieCatalogueRepository).getDetailTvShow(tvId)

        assertNotNull(detailTvEntities)
        assertEquals(dummyDetailTv.data?.id, detailTvEntities.id)
        assertEquals(dummyDetailTv.data?.originalTitle, detailTvEntities.originalTitle)
        assertEquals(dummyDetailTv.data?.overview, detailTvEntities.overview)
        assertEquals(dummyDetailTv.data?.releaseDate, detailTvEntities.releaseDate)
        dummyDetailTv.data?.voteAverage?.let { assertEquals(it, detailTvEntities.voteAverage,0.0001) }
        assertEquals(dummyDetailTv.data?.posterPath, detailTvEntities.posterPath)

        viewModel.setDataTv.observeForever(observerTv)
        verify(observerTv).onChanged(dummyDetailTv)
    }

    @Test
    fun setFavTv(){
        val dummyDetailTv = Resource.success(DataDummy.getDetailTv())
        val tv = MutableLiveData<Resource<TvShowEntity>>()
        tv.value = dummyDetailTv

        Mockito.`when`(movieCatalogueRepository.getDetailTvShow(tvId)).thenReturn(tv)
        viewModel.getData(tvId, "tv")
        viewModel.setFavTv()
        verify(movieCatalogueRepository).setFavoriteTv(tv.value!!.data as TvShowEntity, true)
        verifyNoMoreInteractions(observerTv)

    }

}