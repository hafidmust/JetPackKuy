package com.hafidmust.moviecatalogue3.utils

import androidx.test.espresso.IdlingResource
import androidx.test.espresso.idling.CountingIdlingResource

object EspressoIdlingResources {
    private const val RESOURCE = "GLOBAL"
    private val espressoIdlingResource = CountingIdlingResource(RESOURCE)

    fun increment(){
        espressoIdlingResource.increment()
    }

    fun decrement(){
        espressoIdlingResource.decrement()
    }

    fun getEspressoIdlingResource() : IdlingResource = espressoIdlingResource
}