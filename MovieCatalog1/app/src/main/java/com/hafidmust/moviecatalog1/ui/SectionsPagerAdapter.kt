package com.hafidmust.moviecatalog1.ui

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.hafidmust.moviecatalog1.R
import com.hafidmust.moviecatalog1.ui.movie.MovieFragment
import com.hafidmust.moviecatalog1.ui.tv.TvShowFragment

class SectionsPagerAdapter(private val context: Context, fm : FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    companion object{
        @StringRes
        private val TAB_TITLES = intArrayOf(R.string.movie, R.string.tv)
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getItem(position: Int): Fragment =
        when(position){
            0 -> MovieFragment()
            1 -> TvShowFragment()
            else -> Fragment()
        }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TAB_TITLES[position])
    }

}