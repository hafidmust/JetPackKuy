package com.hafidmust.academy.ui.academy

import org.junit.Assert.*
import org.junit.Before

import org.junit.Test

class AcademyViewModelTest {
    private lateinit var viewModel : AcademyViewModel

    @Before
    fun setup(){
        viewModel = AcademyViewModel()
    }
    @Test
    fun getCourses() {
        val courseEntities = viewModel.getCourses()
        assertNotNull(courseEntities)
        assertEquals(5, courseEntities.size)

    }
}