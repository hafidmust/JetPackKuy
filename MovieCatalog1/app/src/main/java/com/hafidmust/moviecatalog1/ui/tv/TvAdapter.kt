package com.hafidmust.moviecatalog1.ui.tv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hafidmust.moviecatalog1.data.movie.MovieEntity
import com.hafidmust.moviecatalog1.data.tv.TvEntity
import com.hafidmust.moviecatalog1.databinding.ListItemsBinding

class TvAdapter(val clickListener : ClickListener) : RecyclerView.Adapter<TvAdapter.ViewHolder>() {
    private var listMovies = ArrayList<TvEntity>()

    fun setMovies(movies : List<TvEntity>){
        this.listMovies.clear()
        this.listMovies.addAll(movies)
    }
    inner class ViewHolder(private val binding : ListItemsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(tv : TvEntity){
            with(binding){
                Glide.with(itemView.context)
                    .load(tv.posterPath)
                    .into(imgPoster)
                binding.root.setOnClickListener {
                    clickListener.doClick(tv)
                }
            }
        }
    }

    interface ClickListener {
        fun doClick(item : TvEntity)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvAdapter.ViewHolder {
        val binding = ListItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TvAdapter.ViewHolder, position: Int) {
        val movie = listMovies[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int {
        return listMovies.size
    }


}