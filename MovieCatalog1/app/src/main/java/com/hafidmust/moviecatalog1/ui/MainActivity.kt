package com.hafidmust.moviecatalog1.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hafidmust.moviecatalog1.R
import com.hafidmust.moviecatalog1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sectionPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        binding.viewpager.adapter = sectionPagerAdapter
        binding.tabs.setupWithViewPager(binding.viewpager)

        supportActionBar?.elevation = 0f
    }
}