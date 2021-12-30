package com.hafidmust.moviecatalogue2.ui.tv

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.hafidmust.moviecatalogue2.data.source.local.entity.TvShowEntity
import com.hafidmust.moviecatalogue2.databinding.FragmentTvBinding
import com.hafidmust.moviecatalogue2.viewmodel.ViewModelFactory

class TvFragment : Fragment() {

    private lateinit var fragmentTvBinding: FragmentTvBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentTvBinding = FragmentTvBinding.inflate(layoutInflater, container, false)
        return fragmentTvBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity!= null){
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[TvViewModel::class.java]
            val tvAdapter = TvAdapter(object : TvAdapter.ClickListener{
                override fun doClick(item: TvShowEntity) {

                }
            })
            viewModel.getDiscoverTv().observe(viewLifecycleOwner, {tv ->
                tvAdapter.setMovies(tv)
                tvAdapter.notifyDataSetChanged()
            })
            with(fragmentTvBinding.rvTvshow){
                layoutManager = GridLayoutManager(context, 2)
                setHasFixedSize(true)
                adapter = tvAdapter
            }
        }
    }
}