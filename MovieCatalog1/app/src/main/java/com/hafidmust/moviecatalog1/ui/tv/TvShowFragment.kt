package com.hafidmust.moviecatalog1.ui.tv

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.hafidmust.moviecatalog1.R
import com.hafidmust.moviecatalog1.data.tv.TvEntity
import com.hafidmust.moviecatalog1.databinding.FragmentTvShowBinding
import com.hafidmust.moviecatalog1.ui.tv.detail.DetailTvActivity

class TvShowFragment : Fragment() {
   private lateinit var binding : FragmentTvShowBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTvShowBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null){
            val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[TvShowViewModel::class.java]
            val tv = viewModel.getTvs()
            val tvAdapter = TvAdapter(object : TvAdapter.ClickListener{
                override fun doClick(item: TvEntity) {
                    val intent = Intent(
                        activity, DetailTvActivity::class.java
                    ).apply {
                        putExtra(DetailTvActivity.EXTRA_ID, item.id)
                    }
                    startActivity(intent)
                }
            })
            tvAdapter.setMovies(tv)
            with(binding.rvTv){
                layoutManager = GridLayoutManager(context, 2)
                setHasFixedSize(true)
                adapter = tvAdapter
            }
        }
    }

}