package com.hafidmust.moviecatalogue3.ui.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hafidmust.moviecatalogue3.BuildConfig
import com.hafidmust.moviecatalogue3.data.source.local.entity.MovieEntity
import com.hafidmust.moviecatalogue3.databinding.ListItemsBinding

class MovieAdapter(val clickListener : ClickListener) : PagedListAdapter<MovieEntity, MovieAdapter.ViewHolder>(DIFF_CALLBACK) {
    private var listMovies = ArrayList<MovieEntity>()

    inner class ViewHolder(private val binding : ListItemsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movies : MovieEntity){
            with(binding){
                Glide.with(itemView.context)
                    .load(BuildConfig.POSTER_PATH+movies.posterPath)
                    .into(imgPoster)
                root.setOnClickListener {
                    clickListener.doClick(movies)
                }
            }
        }
    }

    interface ClickListener {
        fun doClick(item : MovieEntity)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieAdapter.ViewHolder {
        val binding = ListItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieAdapter.ViewHolder, position: Int) {
        val movie = getItem(position)
        if (movie != null){
            holder.bind(movie)
        }

    }



    companion object{
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<MovieEntity>(){
            override fun areItemsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
                return oldItem == newItem
            }
        }
    }


}