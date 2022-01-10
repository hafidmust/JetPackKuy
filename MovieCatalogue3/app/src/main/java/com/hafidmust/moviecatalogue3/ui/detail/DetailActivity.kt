package com.hafidmust.moviecatalogue3.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.hafidmust.moviecatalogue3.data.source.local.entity.DetailEntity
import com.hafidmust.moviecatalogue3.databinding.ActivityDetailBinding
import com.hafidmust.moviecatalogue3.viewmodel.ViewModelFactory
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
        with(binding){
            contenttitle.text = detail?.originalTitle
            tvcontentdesc.text = detail?.overview
            contentrelease.text = detail?.releaseDate
            contenttvvote.text = detail?.voteAverage.toString()

            val getVote : Int = ((detail?.voteAverage?.div(10.0))?.times(100))?.roundToInt() ?: 0
            contentvote.progress = getVote
            Glide.with(root.context)
                .load("https://image.tmdb.org/t/p/original${detail?.posterPath}")
                .into(contentiamgeposter)
            contentiamgeposter.tag = detail?.posterPath
        }

    }
}