package com.hafidmust.mynoteapps.ui.insert

import android.app.Application
import androidx.lifecycle.ViewModel
import com.hafidmust.mynoteapps.database.Note
import com.hafidmust.mynoteapps.repository.NoteRepository

class NoteAddUpdateViewModel(application: Application) : ViewModel() {
    private val repository : NoteRepository = NoteRepository(application)

    fun insert(note : Note){
        repository.insert(note)
    }

    fun update(note: Note) {
        repository.update(note)
    }
    fun delete(note: Note) {
        repository.delete(note)
    }
}