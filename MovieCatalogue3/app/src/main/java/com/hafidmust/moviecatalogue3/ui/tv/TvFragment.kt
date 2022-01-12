package com.hafidmust.moviecatalogue3.ui.tv

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.hafidmust.moviecatalogue3.data.source.local.entity.TvShowEntity
import com.hafidmust.moviecatalogue3.databinding.FragmentTvBinding
import com.hafidmust.moviecatalogue3.ui.detail.DetailActivity
import com.hafidmust.moviecatalogue3.viewmodel.ViewModelFactory
import com.hafidmust.moviecatalogue3.vo.Status

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
                    val intent = Intent(
                        activity, DetailActivity::class.java
                    ).apply {
                        putExtra(DetailActivity.EXTRA_ID, item.id)
                        putExtra(DetailActivity.EXTRA_TYPE,"tv")
                    }
                    startActivity(intent)
                }
            })
            viewModel.getDiscoverTv().observe(viewLifecycleOwner, {tv ->
                if(tv != null){
                    when(tv.status){
                        Status.SUCCESS ->{
                            fragmentTvBinding.progressBar.visibility = View.GONE
                            tv.data?.let { tvAdapter.setMovies(it) }
                            tvAdapter.notifyDataSetChanged()
                        }
                        Status.LOADING -> fragmentTvBinding.progressBar.visibility = View.VISIBLE
                        Status.ERROR -> Toast.makeText(context, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                    }
                }
            })
            with(fragmentTvBinding.rvTvshow){
                layoutManager = GridLayoutManager(context, 2)
                setHasFixedSize(true)
                adapter = tvAdapter
            }
        }
    }
}