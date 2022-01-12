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
        onView(withId(R.id.contenttvvote)).check(matches(isDisplayed()))
        onView(withId(R.id.tvcontentdesc)).check(matches(isDisplayed()))
        onView(withId(R.id.contentrelease)).check(matches(isDisplayed()))
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
        onView(withId(R.id.contenttvvote)).check(matches(isDisplayed()))
        onView(withId(R.id.tvcontentdesc)).check(matches(isDisplayed()))
        onView(withId(R.id.contentrelease)).check(matches(isDisplayed()))
        onView(withId(R.id.contentiamgeposter)).check(matches(isDisplayed()))
    }

    @Test
    fun loadFavMovie(){
        onView(withId(R.id.action_to_favorite)).perform(click())
        onView(withId(R.id.rv_favoritemovie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_favoritemovie)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyMovies.size
            )
        )
    }

    @Test
    fun loadDetailFavMovies(){
        onView(withId(R.id.action_to_favorite)).perform(click())
        onView(withId(R.id.rv_favoritemovie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_favoritemovie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0,
            click()))
        onView(withId(R.id.contenttitle)).check(matches(isDisplayed()))
        onView(withId(R.id.contenttvvote)).check(matches(isDisplayed()))
        onView(withId(R.id.tvcontentdesc)).check(matches(isDisplayed()))
        onView(withId(R.id.contentrelease)).check(matches(isDisplayed()))
        onView(withId(R.id.contentiamgeposter)).check(matches(isDisplayed()))
    }

    @Test
    fun loadFavTv(){
        onView(withId(R.id.action_to_favorite)).perform(click())
        onView(withText("Tv Show")).perform(click())
        onView(withId(R.id.rv_favoritetv)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_favoritetv)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyMovies.size
            )
        )
    }

    @Test
    fun loadDetailFavTv(){
        onView(withId(R.id.action_to_favorite)).perform(click())
        onView(withText("Tv Show")).perform(click())
        onView(withId(R.id.rv_favoritetv)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0,
            click()))
        onView(withId(R.id.contenttitle)).check(matches(isDisplayed()))
        onView(withId(R.id.contenttvvote)).check(matches(isDisplayed()))
        onView(withId(R.id.tvcontentdesc)).check(matches(isDisplayed()))
        onView(withId(R.id.contentrelease)).check(matches(isDisplayed()))
        onView(withId(R.id.contentiamgeposter)).check(matches(isDisplayed()))
    }


}