package com.hafidmust.moviecatalog1.ui.tv.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.hafidmust.moviecatalog1.R
import com.hafidmust.moviecatalog1.data.tv.TvEntity
import com.hafidmust.moviecatalog1.databinding.ActivityDetailTvBinding

class DetailTvActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDetailTvBinding
    companion object{
        const val EXTRA_ID = "extra_id"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailTvBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[DetailTvViewModel::class.java]

        val extras = intent.extras
        if (extras != null){
            val tvId = extras.getString(EXTRA_ID)
            if (tvId != null){
                viewModel.setSelectedMovie(tvId)
                populateTv(viewModel.getTvs())
            }
        }
    }

    private fun populateTv(tvs: TvEntity) {
        binding.contenttitle.text = tvs.originalTitle
        binding.tvcontentdesc.text = tvs.overview
        binding.contentrelease.text = tvs.season
//        binding.contentcategory.text = tvs.category
        Glide.with(this)
            .load(tvs.posterPath)
            .into(binding.contentiamgeposter)
    }
}