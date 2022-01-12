package com.hafidmust.moviecatalogue3.ui.tv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hafidmust.moviecatalogue3.BuildConfig
import com.hafidmust.moviecatalogue3.data.source.local.entity.MovieEntity
import com.hafidmust.moviecatalogue3.data.source.local.entity.TvShowEntity
import com.hafidmust.moviecatalogue3.databinding.ListItemsBinding

class TvAdapter(val clickListener : ClickListener) : PagedListAdapter<TvShowEntity, TvAdapter.ViewHolder>(DIFF_CALLBACK) {
    private var listTv = ArrayList<TvShowEntity>()

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
        val movie = getItem(position)
        if (movie != null){
            holder.bind(movie)
        }
    }



    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TvShowEntity>() {
            override fun areItemsTheSame(oldItem: TvShowEntity, newItem: TvShowEntity): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: TvShowEntity, newItem: TvShowEntity): Boolean {
                return oldItem == newItem
            }
        }
    }


}