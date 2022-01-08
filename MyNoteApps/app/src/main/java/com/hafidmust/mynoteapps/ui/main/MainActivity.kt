package com.hafidmust.mynoteapps.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.hafidmust.mynoteapps.R
import com.hafidmust.mynoteapps.database.Note
import com.hafidmust.mynoteapps.databinding.ActivityMainBinding
import com.hafidmust.mynoteapps.helper.SortUtils
import com.hafidmust.mynoteapps.ui.insert.NoteAddUpdateActivity
import com.hafidmust.mynoteapps.viewmodel.ViewModelFactory

class MainActivity : AppCompatActivity() {
    private var _activityMainBinding : ActivityMainBinding? = null
    private val binding get() = _activityMainBinding
    private lateinit var mainViewModel: MainViewModel

    private lateinit var adapter: NotePagedListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        mainViewModel = obtainViewModel(this@MainActivity)
        mainViewModel.getAllNotes(SortUtils.NEWEST).observe(this, noteObserver)

        adapter = NotePagedListAdapter(this@MainActivity)

        binding?.rvNotes?.layoutManager = LinearLayoutManager(this)
        binding?.rvNotes?.setHasFixedSize(true)
        binding?.rvNotes?.adapter = adapter

        binding?.fabAdd?.setOnClickListener {
            if (it.id == R.id.fab_add){
                val intent = Intent(this, NoteAddUpdateActivity::class.java)
                startActivityForResult(intent, NoteAddUpdateActivity.REQUEST_ADD)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (data != null){
            if (requestCode == NoteAddUpdateActivity.REQUEST_ADD){
                if (resultCode == NoteAddUpdateActivity.RESULT_ADD){
                    showSnackbarMessage(getString(R.string.added))
                }
            }else if (requestCode == NoteAddUpdateActivity.REQUEST_UPDATE){
                if (resultCode == NoteAddUpdateActivity.RESULT_UPDATE){
                    showSnackbarMessage(getString(R.string.changed))
                }else if(resultCode == NoteAddUpdateActivity.RESULT_DELETE){
                    showSnackbarMessage(getString(R.string.deleted))
                }
            }
        }
    }

    private fun showSnackbarMessage(string: String) {
        Snackbar.make(binding?.root as View, string, Snackbar.LENGTH_SHORT).show()
    }

    private fun obtainViewModel(activity: AppCompatActivity): MainViewModel {
        val factory = ViewModelFactory.getInstance(activity.application)
        return ViewModelProvider(activity,factory).get(MainViewModel::class.java)
    }

    private val noteObserver = Observer<PagedList<Note>>{ noteList ->
        if (noteList != null){
            adapter.submitList(noteList)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _activityMainBinding = null
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var sort = ""
        when(item.itemId){
            R.id.action_newest -> sort = SortUtils.NEWEST
            R.id.action_oldest -> sort = SortUtils.OLDEST
            R.id.action_random -> sort = SortUtils.RANDOM
        }
        mainViewModel.getAllNotes(sort).observe(this, noteObserver)
        item.isChecked = true
        return super.onOptionsItemSelected(item)
    }
}