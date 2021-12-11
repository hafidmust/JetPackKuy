package com.hafidmust.myviewmodel

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule

import org.junit.Test
import org.junit.rules.ExpectedException
import java.lang.NumberFormatException

class MainViewModelTest {
    private lateinit var mainViewModel: MainViewModel

    @Before
    fun init(){
        mainViewModel = MainViewModel()
    }

    @Test
    fun calculate() {
        val w = "1"
        val l = "2"
        val h = "3"
        mainViewModel.calculate(w,h,l)
        assertEquals(6,mainViewModel.result)
    }

    @get:Rule
    var thrown = ExpectedException.none()

    @Test
    @Throws(NumberFormatException::class)
    fun doubleInputCalculate(){
        val w = "1"
        val l = "2.4"
        val h = "3"
        thrown.expect(NumberFormatException::class.java)
        thrown.expectMessage("For input string: \"2.4\"")
        mainViewModel.calculate(w,l,h)
    }

    @Test
    @Throws(java.lang.NumberFormatException::class)
    fun characterInputCalculateTest() {
        val width = "1"
        val length = "A"
        val height = "3"
        thrown.expect(java.lang.NumberFormatException::class.java)
        thrown.expectMessage("For input string: \"A\"")
        mainViewModel.calculate(width, length, height)
    }
    @Test
    @Throws(java.lang.NumberFormatException::class)
    fun emptyInputCalculateTest() {
        val width = "1"
        val length = ""
        val height = "3"
        thrown.expect(java.lang.NumberFormatException::class.java)
        thrown.expectMessage("For input string: \"\"")
        mainViewModel.calculate(width, height, length)
    }
}