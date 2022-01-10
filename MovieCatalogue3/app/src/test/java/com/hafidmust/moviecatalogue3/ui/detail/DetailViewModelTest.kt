package com.hafidmust.moviecatalogue3.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.hafidmust.moviecatalogue3.data.source.MovieCatalogueRepository
import com.hafidmust.moviecatalogue3.data.source.local.entity.DetailEntity
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
class DetailViewModelTest {
    private lateinit var viewModel: DetailViewModel
    private val dummyDetailMovie = DataDummy.getDetailMovie()
    private val dummyDetailTv = DataDummy.getDetailTv()
    private val movieId = dummyDetailMovie.idEntity
    private val tvId = dummyDetailTv.idEntity

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieCatalogueRepository: MovieCatalogueRepository

    @Mock
    private lateinit var observer : Observer<DetailEntity>

    @Before
    fun setUp() {
        viewModel = DetailViewModel(movieCatalogueRepository)
    }

    @Test
    fun getDataMovie() {
        val dataMovie = MutableLiveData<DetailEntity>()
        dataMovie.value = dummyDetailMovie

        `when`(movieCatalogueRepository.getDetailMovie(movieId)).thenReturn(dataMovie)
        viewModel.getData(movieId,"movie")
        val detailMovieEntities = viewModel.setData.value as DetailEntity
        verify(movieCatalogueRepository).getDetailMovie(movieId)

        assertNotNull(detailMovieEntities)
        assertEquals(dummyDetailMovie.idEntity, detailMovieEntities.idEntity)
        assertEquals(dummyDetailMovie.originalTitle, detailMovieEntities.originalTitle)
        assertEquals(dummyDetailMovie.overview, detailMovieEntities.overview)
        assertEquals(dummyDetailMovie.releaseDate, detailMovieEntities.releaseDate)
        assertEquals(dummyDetailMovie.voteAverage, detailMovieEntities.voteAverage, 0.0001)
        assertEquals(dummyDetailMovie.posterPath, detailMovieEntities.posterPath)


        viewModel.setData.observeForever(observer)
        verify(observer).onChanged(dummyDetailMovie)
    }

    @Test
    fun getDataTv(){
        val dataTv = MutableLiveData<DetailEntity>()
        dataTv.value = dummyDetailTv
        `when`(movieCatalogueRepository.getDetailTvShow(tvId)).thenReturn(dataTv)
        viewModel.getData(tvId, "tv")
        val detailTvEntities = viewModel.setData.value as DetailEntity
        verify(movieCatalogueRepository).getDetailTvShow(tvId)

        assertNotNull(detailTvEntities)
        assertEquals(dummyDetailTv.idEntity, detailTvEntities.idEntity)
        assertEquals(dummyDetailTv.originalTitle, detailTvEntities.originalTitle)
        assertEquals(dummyDetailTv.overview, detailTvEntities.overview)
        assertEquals(dummyDetailTv.releaseDate, detailTvEntities.releaseDate)
        assertEquals(dummyDetailTv.voteAverage, detailTvEntities.voteAverage,0.0001)
        assertEquals(dummyDetailTv.posterPath, detailTvEntities.posterPath)

        viewModel.setData.observeForever(observer)
        verify(observer).onChanged(dummyDetailTv)
    }
}