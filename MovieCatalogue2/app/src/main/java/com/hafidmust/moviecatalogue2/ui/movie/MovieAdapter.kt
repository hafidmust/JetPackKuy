package com.hafidmust.moviecatalogue2.ui.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hafidmust.moviecatalogue2.data.source.remote.response.ResultsItem
import com.hafidmust.moviecatalogue2.databinding.ListItemsBinding

class MovieAdapter(val clickListener : ClickListener) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {
    private var listMovies = ArrayList<ResultsItem>()

    fun setMovies(movies : List<ResultsItem>){
        this.listMovies.clear()
        this.listMovies.addAll(movies)
    }
    inner class ViewHolder(private val binding : ListItemsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movies : ResultsItem){
            with(binding){
                Glide.with(itemView.context)
                    .load("https://image.tmdb.org/t/p/original${movies.posterPath}")
                    .into(imgPoster)
                binding.root.setOnClickListener {
                    clickListener.doClick(movies)
                }
            }
        }
    }

    interface ClickListener {
        fun doClick(item : ResultsItem)

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