package com.hafidmust.moviecatalogue3.ui.tv

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.hafidmust.moviecatalogue3.MainActivity
import com.hafidmust.moviecatalogue3.R
import com.hafidmust.moviecatalogue3.data.source.local.entity.TvShowEntity
import com.hafidmust.moviecatalogue3.databinding.FragmentTvBinding
import com.hafidmust.moviecatalogue3.ui.detail.DetailActivity
import com.hafidmust.moviecatalogue3.ui.favorite.FavoriteActivity
import com.hafidmust.moviecatalogue3.utils.Sortutils
import com.hafidmust.moviecatalogue3.utils.Sortutils.NEWEST
import com.hafidmust.moviecatalogue3.viewmodel.ViewModelFactory
import com.hafidmust.moviecatalogue3.vo.Status

class TvFragment : Fragment() {

    private lateinit var fragmentTvBinding: FragmentTvBinding
    private lateinit var viewModel: TvViewModel
    private lateinit var tvAdapter: TvAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentTvBinding = FragmentTvBinding.inflate(layoutInflater, container, false)
        setHasOptionsMenu(true)
        return fragmentTvBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity!= null){
            (activity as MainActivity).setActionBarTitle("Discover Tv Show")
            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(this, factory)[TvViewModel::class.java]
            tvAdapter = TvAdapter(object : TvAdapter.ClickListener{
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
            viewModel.getDiscoverTv(NEWEST).observe(viewLifecycleOwner, {tv ->
                if(tv != null){
                    when(tv.status){
                        Status.SUCCESS ->{
                            fragmentTvBinding.progressBar.visibility = View.GONE
                            tvAdapter.submitList(tv.data)
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

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.clear()
        activity?.menuInflater?.inflate(R.menu.sort, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var sort = ""
        when(item.itemId){
            R.id.action_newest -> sort = NEWEST
            R.id.action_older -> sort = Sortutils.OLDEST
            R.id.action_to_favorite -> {
                startActivity(Intent(context, FavoriteActivity::class.java))
            }
        }
        viewModel.getDiscoverTv(sort).observe(viewLifecycleOwner, {
            if (it != null){
                when(it.status){
                    Status.LOADING -> fragmentTvBinding.progressBar.visibility = View.VISIBLE
                    Status.SUCCESS -> {
                        fragmentTvBinding.progressBar.visibility = View.GONE
                        tvAdapter.submitList(it.data)
                    }
                    Status.ERROR->{
                        Toast.makeText(context, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })
        item.isChecked = true
        return super.onOptionsItemSelected(item)
    }
}