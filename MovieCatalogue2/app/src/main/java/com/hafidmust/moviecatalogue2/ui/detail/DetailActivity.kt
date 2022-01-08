package com.hafidmust.moviecatalogue2.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.hafidmust.moviecatalogue2.data.source.local.entity.DetailEntity
import com.hafidmust.moviecatalogue2.databinding.ActivityDetailBinding
import com.hafidmust.moviecatalogue2.viewmodel.ViewModelFactory
import kotlin.math.roundToInt

class DetailActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDetailBinding

    companion object{
        const val EXTRA_ID = "extra_id"
        const val EXTRA_TYPE = "extra_type"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        val factory = ViewModelFactory.getInstance(this)
        val viewModel = ViewModelProvider(this, factory)[DetailViewModel::class.java]

        val extras = intent.extras
        if (extras != null){
            val dataId = extras.getInt(EXTRA_ID,0)
            val getType = extras.getString(EXTRA_TYPE)
            if (getType != null) {
                viewModel.getData(dataId,getType)
                viewModel.setData.observe(this,{
                    populateDetail(it)
                })

            }
        }
    }

    private fun populateDetail(detail: DetailEntity?) {
        binding.contenttitle.text = detail?.originalTitle
        binding.tvcontentdesc.text = detail?.overview
        binding.contentrelease.text = detail?.releaseDate
        binding.contenttvvote.text = detail?.voteAverage.toString()

        val getVote : Int = ((detail?.voteAverage?.div(10.0))?.times(100))?.roundToInt() ?: 0
        binding.contentvote.progress = getVote
        Glide.with(this)
            .load("https://image.tmdb.org/t/p/original${detail?.posterPath}")
            .into(binding.contentiamgeposter)
        binding.contentiamgeposter.tag = detail?.posterPath
    }
}