package com.hafidmust.moviecatalog1.ui.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hafidmust.moviecatalog1.data.movie.MovieEntity
import com.hafidmust.moviecatalog1.databinding.ListItemsBinding

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {
    private var listMovies = ArrayList<MovieEntity>()

    fun setMovies(movies : List<MovieEntity>){
        this.listMovies.clear()
        this.listMovies.addAll(movies)
    }
    class ViewHolder(private val binding : ListItemsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movies : MovieEntity){
            with(binding){
                Glide.with(itemView.context)
                    .load(movies.posterPath)
                    .into(imgPoster)
                binding.tvContentTitle.text = movies.title
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieAdapter.ViewHolder {
        val binding = ListItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieAdapter.ViewHolder, position: Int) {
        val movie = listMovies[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int {
        return listMovies.size
    }


}