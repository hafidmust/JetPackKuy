package com.hafidmust.moviecatalogue3.ui.detail

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.hafidmust.moviecatalogue3.R
import com.hafidmust.moviecatalogue3.data.source.local.entity.DetailEntity
import com.hafidmust.moviecatalogue3.data.source.local.entity.MovieEntity
import com.hafidmust.moviecatalogue3.data.source.local.entity.TvShowEntity
import com.hafidmust.moviecatalogue3.databinding.ActivityDetailBinding
import com.hafidmust.moviecatalogue3.viewmodel.ViewModelFactory
import com.hafidmust.moviecatalogue3.vo.Status
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
                if (getType == "movie"){
                    viewModel.setDataMovie.observe(this,{
                        when(it.status){
//                            loading
                            Status.SUCCESS ->{
                                if (it.data != null){
//                                    disable loading
                                    populateDetail(it.data)
                                    val state = it.data.isFavorite
                                    setFavoriteState(state)
                                }
                            }
                            Status.ERROR ->{
//                                disable loading
                                Toast.makeText(this, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                            }
                        }
//                        populateDetail(it)
                    })
                }else if(getType == "tv"){
                    viewModel.setDataTv.observe(this,{
                        when(it.status){
                            Status.SUCCESS ->{
                                if (it.data != null) {
                                    populateDetailTv(it.data)
                                    val state = it.data.isFavorite
                                    setFavoriteState(state)
                                }
                            }
                            Status.ERROR -> Toast.makeText(this, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                        }
                    })
                }

            }
        }
        binding.fabFav.setOnClickListener {
            val getType = extras?.getString(EXTRA_TYPE)
            if (getType == "movie"){
                viewModel.setFavMovie()
            }else if(getType == "tv"){
                viewModel.setFavTv()
            }
        }
    }

    private fun setFavoriteState(state: Boolean) {
        if (state){
            binding.fabFav.setImageResource(R.drawable.ic_favorited_24)
        }else{
            binding.fabFav.setImageResource(R.drawable.ic_favorite_border_24)
        }
    }

    private fun populateDetail(detail: MovieEntity?) {
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
    private fun populateDetailTv(detail: TvShowEntity?) {
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