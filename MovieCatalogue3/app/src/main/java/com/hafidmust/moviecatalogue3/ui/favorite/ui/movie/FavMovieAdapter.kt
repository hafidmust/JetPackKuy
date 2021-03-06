package com.hafidmust.moviecatalogue3.ui.favorite.ui.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hafidmust.moviecatalogue3.BuildConfig
import com.hafidmust.moviecatalogue3.data.source.local.entity.MovieEntity
import com.hafidmust.moviecatalogue3.databinding.ListItemsBinding

class FavMovieAdapter(val clickListener : ClickListener) : RecyclerView.Adapter<FavMovieAdapter.ViewHolder>() {
    private var listMovies = ArrayList<MovieEntity>()

    fun setMovies(movies : List<MovieEntity>){
        this.listMovies.clear()
        this.listMovies.addAll(movies)
    }
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavMovieAdapter.ViewHolder {
        val binding = ListItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FavMovieAdapter.ViewHolder, position: Int) {
        val movie = listMovies[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int {
        return listMovies.size
    }


}