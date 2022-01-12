package com.hafidmust.moviecatalogue3.ui.favorite.ui.tv

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.hafidmust.moviecatalogue3.R
import com.hafidmust.moviecatalogue3.data.source.local.entity.TvShowEntity
import com.hafidmust.moviecatalogue3.databinding.FragmentFavTvBinding
import com.hafidmust.moviecatalogue3.ui.detail.DetailActivity
import com.hafidmust.moviecatalogue3.ui.tv.TvAdapter
import com.hafidmust.moviecatalogue3.viewmodel.ViewModelFactory


class FavTvFragment : Fragment() {
    private lateinit var binding: FragmentFavTvBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFavTvBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(activity != null){
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[FavTvViewModel::class.java]
            val tvAdapter = TvAdapter(object : TvAdapter.ClickListener{
                override fun doClick(item: TvShowEntity) {
                    val intent = Intent(
                        activity, DetailActivity::class.java
                    ).apply {
                        putExtra(DetailActivity.EXTRA_ID, item.id)
                        putExtra(DetailActivity.EXTRA_TYPE, "tv")
                    }
                    startActivity(intent)
                }
            })

            viewModel.getFavoriteTv().observe(viewLifecycleOwner, {
                if (it != null){
                    tvAdapter.submitList(it)
                }
            })

            with(binding.rvFavoritetv){
                layoutManager = GridLayoutManager(context, 2)
                setHasFixedSize(true)
                adapter = tvAdapter
            }
        }
    }

}