package com.hafidmust.moviecatalog1.ui

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.hafidmust.moviecatalog1.R
import com.hafidmust.moviecatalog1.utils.DataDummy
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

class MainActivityTest{
    private val dummyMovie = DataDummy.generateDumyMovie()
    private val dummyTv = DataDummy.generateDumyTv()

    @get:Rule
    var activityRule = ActivityScenarioRule(MainActivity::class.java)


    @Test
    fun loadMovies(){
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovie.size))
    }

    @Test
    fun loadDetailMovie(){
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0,click()))
        onView(withId(R.id.contenttitle)).check(matches(isDisplayed()))
        onView(withId(R.id.contenttitle)).check(matches(withText(dummyMovie[0].originalTitle)))
        onView(withId(R.id.tvcontentdesc)).check(matches(isDisplayed()))
        onView(withId(R.id.tvcontentdesc)).check(matches(withText(dummyMovie[0].overview)))
    }

    @Test
    fun loadTv(){
        onView(withText("Tv Show")).perform(click())
        onView(withId(R.id.rv_tv)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tv)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTv.size))
    }
    @Test
    fun loadDetailTv(){
        onView(withText("Tv Show")).perform(click())
        onView(withId(R.id.rv_tv)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tv)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTv.size))

        onView(withId(R.id.rv_tv)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0,click()))
        onView(withId(R.id.contenttitle)).check(matches(isDisplayed()))
        onView(withId(R.id.contenttitle)).check(matches(withText(dummyTv[0].originalTitle)))
        onView(withId(R.id.tvcontentdesc)).check(matches(isDisplayed()))
        onView(withId(R.id.tvcontentdesc)).check(matches(withText(dummyTv[0].overview)))
    }
}