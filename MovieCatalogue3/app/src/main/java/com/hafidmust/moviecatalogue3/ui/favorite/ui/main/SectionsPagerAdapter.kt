package com.hafidmust.moviecatalogue3.ui.favorite.ui.main

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.hafidmust.moviecatalogue3.R
import com.hafidmust.moviecatalogue3.ui.favorite.ui.movie.FavMovieFragment
import com.hafidmust.moviecatalogue3.ui.favorite.ui.tv.FavTvFragment

private val TAB_TITLES = arrayOf(
    R.string.movie,
    R.string.tv_show
)
class SectionsPagerAdapter(activity: AppCompatActivity) :
    FragmentStateAdapter(activity) {

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when(position){
            0 -> fragment = FavMovieFragment()
            1 -> fragment = FavTvFragment()
        }
        return fragment as Fragment
    }

    companion object{
        val TAB_TITLES = arrayOf(
            R.string.movie,
            R.string.tv_show
        )
    }
}