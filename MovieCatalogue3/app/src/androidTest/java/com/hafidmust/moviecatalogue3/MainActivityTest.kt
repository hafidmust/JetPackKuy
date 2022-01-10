package com.hafidmust.moviecatalogue3

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import com.hafidmust.moviecatalogue3.utils.DataDummy
import com.hafidmust.moviecatalogue3.utils.EspressoIdlingResources
import org.junit.After
import org.junit.Before
import org.junit.Test

class MainActivityTest {
    private val dummyMovies = DataDummy.getMovie()
    private val dummyTv = DataDummy.getTv()
    private val dummyDetailMovie = DataDummy.getDetailMovie()
    private val dummyDetailTv = DataDummy.getDetailTv()

    @Before
    fun setUp() {
        ActivityScenario.launch(MainActivity::class.java)
        IdlingRegistry.getInstance().register(EspressoIdlingResources.getEspressoIdlingResource())
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResources.getEspressoIdlingResource())
    }

    @Test
    fun loadMovies(){
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovies.size))

    }

    @Test
    fun loadDetailMovies(){
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0,
            click()))
        onView(withId(R.id.contenttitle)).check(matches(isDisplayed()))
        onView(withId(R.id.contenttitle)).check(matches(withText(dummyDetailMovie.originalTitle)))

        onView(withId(R.id.contenttvvote)).check(matches(isDisplayed()))
        onView(withId(R.id.contenttvvote)).check(matches(withText(dummyDetailMovie.voteAverage.toString())))

        onView(withId(R.id.tvcontentdesc)).check(matches(isDisplayed()))
        onView(withId(R.id.tvcontentdesc)).check(matches(withText(dummyDetailMovie.overview)))

        onView(withId(R.id.contentrelease)).check(matches(isDisplayed()))
        onView(withId(R.id.contentrelease)).check(matches(withText(dummyDetailMovie.releaseDate)))

        onView(withId(R.id.contentiamgeposter)).check(matches(isDisplayed()))

    }

    @Test
    fun loadTvShow(){
        onView(withId(R.id.navigation_tv_show)).perform(click())
        onView(withId(R.id.rv_tvshow)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tvshow)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTv.size))
    }

    @Test
    fun loadDetailTv(){
        onView(withId(R.id.navigation_tv_show)).perform(click())
        onView(withId(R.id.rv_tvshow)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0,
            click()))
        onView(withId(R.id.contenttitle)).check(matches(isDisplayed()))
        onView(withId(R.id.contenttitle)).check(matches(withText(dummyDetailTv.originalTitle)))

        onView(withId(R.id.contenttvvote)).check(matches(isDisplayed()))
        onView(withId(R.id.contenttvvote)).check(matches(withText(dummyDetailTv.voteAverage.toString())))

        onView(withId(R.id.tvcontentdesc)).check(matches(isDisplayed()))
        onView(withId(R.id.tvcontentdesc)).check(matches(withText(dummyDetailTv.overview)))

        onView(withId(R.id.contentrelease)).check(matches(isDisplayed()))
        onView(withId(R.id.contentrelease)).check(matches(withText(dummyDetailTv.releaseDate)))

        onView(withId(R.id.contentiamgeposter)).check(matches(isDisplayed()))
    }
}