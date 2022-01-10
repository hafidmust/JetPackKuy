package com.hafidmust.moviecatalogue3.ui.favorite.ui.main

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.hafidmust.moviecatalogue3.R
import com.hafidmust.moviecatalogue3.ui.favorite.ui.movie.FavMovieFragment
import com.hafidmust.moviecatalogue3.ui.favorite.ui.tv.FavTvFragment

private val TAB_TITLES = arrayOf(
    R.string.movie,
    R.string.tv_show
)
class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
         when(position){
            0 -> return FavMovieFragment()
            1 -> return FavTvFragment()
        }
        return Fragment()
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TAB_TITLES[position])
    }

    override fun getCount(): Int {
        // Show 2 total pages.
        return 2
    }
}