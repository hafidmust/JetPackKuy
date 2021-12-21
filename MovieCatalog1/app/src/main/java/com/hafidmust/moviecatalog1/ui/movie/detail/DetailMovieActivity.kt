package com.hafidmust.moviecatalog1.ui.movie.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.hafidmust.moviecatalog1.R
import com.hafidmust.moviecatalog1.data.movie.MovieEntity
import com.hafidmust.moviecatalog1.databinding.ActivityDetailBinding
import com.hafidmust.moviecatalog1.utils.DataDummy

class DetailMovieActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDetailBinding
    companion object{
        const val EXTRA_ID = "extra_id"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        val extras = intent.extras
        if (extras != null){
            val movieId = extras.getString(EXTRA_ID)
            if (movieId != null){
                for(movie in DataDummy.generateDumyMovie()){
                    if (movie.id == movieId){
                        populateMovie(movie)
                    }
                }
            }

        }
    }

    private fun populateMovie(movieEntity: MovieEntity) {
        binding.contenttitle.text = movieEntity.originalTitle
        binding.tvcontentdesc.text = movieEntity.overview
        binding.contentrelease.text = movieEntity.releaseDate
        binding.contentcategory.text = movieEntity.category
        Glide.with(this)
            .load(movieEntity.posterPath)
            .into(binding.contentiamgeposter)
    }
}