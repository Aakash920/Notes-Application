package com.example.android.mynotes

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModel(application: Application) : AndroidViewModel(application) {

    val allNotes : LiveData<List<Note>>
    private val repository: NoteRepository
    init {
        //get dao from NotesDatabase
        val dao = NotesDatabase.getDatabase(application).getNoteDao()
        //so, initialise Repository cause we have dao now!!
        repository = NoteRepository(dao)
        allNotes = repository.allNotes


    }
    fun deleteNote(note : Note) = viewModelScope.launch(Dispatchers.IO){
        repository.delete(note)
    }
    fun insertNote(note: Note) = viewModelScope.launch(Dispatchers.IO){
        repository.insert(note)
    }
}