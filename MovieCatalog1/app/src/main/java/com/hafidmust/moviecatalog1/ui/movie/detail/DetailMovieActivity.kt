package com.hafidmust.moviecatalog1.ui.movie.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hafidmust.moviecatalog1.R

class DetailMovieActivity : AppCompatActivity() {
    companion object{
        const val EXTRA_MOVIE = "extra_movie"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
    }
}