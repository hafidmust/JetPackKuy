package com.hafidmust.mynoteapps.ui.main

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.hafidmust.mynoteapps.database.Note
import com.hafidmust.mynoteapps.repository.NoteRepository

class MainViewModel(application: Application) : ViewModel()  {
    private val repository : NoteRepository = NoteRepository(application)

    fun getAllNotes() : LiveData<List<Note>> = repository.getAllNotes()
}