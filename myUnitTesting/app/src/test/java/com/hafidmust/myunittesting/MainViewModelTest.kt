package com.hafidmust.myunittesting

import org.junit.Assert.*
import org.junit.Before

import org.junit.Test
import org.mockito.Mockito.*

class MainViewModelTest {
//    persiapkan kode" yg akan ditest
    private lateinit var mainViewModel: MainViewModel
    private lateinit var cuboidModel: CuboidModel

    private val dummyLength = 12.0
    private val dummyHeight = 18.0
    private val dummyWidth = 80.0

    private val dummyVolume = 17280.0
    private val dummyCircumferece = 440.0
    private val dummySUrfaceArea = 5232.0



    @Before
    fun before(){
        cuboidModel = mock(CuboidModel::class.java)
        mainViewModel = MainViewModel(cuboidModel)
    }

    @Test
    fun getCircumference() {
        cuboidModel = CuboidModel()
        mainViewModel = MainViewModel(cuboidModel)
        mainViewModel.save(dummyWidth,dummyLength,dummyHeight)
        val circum = mainViewModel.getCircumference()
        assertEquals(dummyCircumferece, circum, 0.0001)
    }

    @Test
    fun getSurfaceArea() {
        cuboidModel = CuboidModel()
        mainViewModel = MainViewModel(cuboidModel)
        mainViewModel.save(dummyWidth,dummyLength,dummyHeight)
        val surfacearea = mainViewModel.getSurfaceArea()
        assertEquals(dummySUrfaceArea, surfacearea, 0.0001)
    }

    @Test
    fun getVolume() {
        cuboidModel = CuboidModel()
        mainViewModel = MainViewModel(cuboidModel)
        mainViewModel.save(dummyWidth,dummyLength,dummyHeight)
        val volume = mainViewModel.getVolume()
        assertEquals(dummyVolume, volume, 0.0001)
    }

    @Test
    fun testMockVOlume(){
        `when`(mainViewModel.getVolume()).thenReturn(dummyVolume)
        val volume = mainViewModel.getVolume()
        verify(cuboidModel).getVolume()
        assertEquals(dummyVolume, volume, 0.0001)
    }
    @Test
    fun testMockSurfece(){
        `when`(mainViewModel.getSurfaceArea()).thenReturn(dummySUrfaceArea)
        val surface = mainViewModel.getSurfaceArea()
        verify(cuboidModel).getSurfaceArea()
        assertEquals(dummySUrfaceArea,surface,0.0001)
    }
    @Test
    fun testMockCircum(){
        `when`(mainViewModel.getCircumference()).thenReturn(dummyCircumferece)
        val circum = mainViewModel.getCircumference()
        verify(cuboidModel).getCircumference()
        assertEquals(dummyCircumferece,circum,0.0001)
    }

}