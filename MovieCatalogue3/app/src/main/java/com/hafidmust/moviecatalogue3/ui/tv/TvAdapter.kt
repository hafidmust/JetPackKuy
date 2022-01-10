package com.hafidmust.moviecatalogue3.ui.tv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hafidmust.moviecatalogue3.data.source.local.entity.TvShowEntity
import com.hafidmust.moviecatalogue3.databinding.ListItemsBinding

class TvAdapter(val clickListener : ClickListener) : RecyclerView.Adapter<TvAdapter.ViewHolder>() {
    private var listTv = ArrayList<TvShowEntity>()

    fun setMovies(movies : List<TvShowEntity>){
        this.listTv.clear()
        this.listTv.addAll(movies)
    }
    inner class ViewHolder(private val binding : ListItemsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movies : TvShowEntity){
            with(binding){
                Glide.with(itemView.context)
                    .load(BuildConfig.POSTER_PATH+movies.posterPath)
                    .into(imgPoster)
                binding.root.setOnClickListener {
                    clickListener.doClick(movies)
                }
            }
        }
    }

    interface ClickListener {
        fun doClick(item : TvShowEntity)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvAdapter.ViewHolder {
        val binding = ListItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TvAdapter.ViewHolder, position: Int) {
        val movie = listTv[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int {
        return listTv.size
    }


}