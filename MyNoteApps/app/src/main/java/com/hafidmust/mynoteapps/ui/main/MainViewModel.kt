package com.hafidmust.mynoteapps.ui.main

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.hafidmust.mynoteapps.database.Note
import com.hafidmust.mynoteapps.repository.NoteRepository

class MainViewModel(application: Application) : ViewModel()  {
    private val repository : NoteRepository = NoteRepository(application)

    fun getAllNotes() : LiveData<PagedList<Note>> = LivePagedListBuilder(repository.getAllNotes(), 20).build()
}