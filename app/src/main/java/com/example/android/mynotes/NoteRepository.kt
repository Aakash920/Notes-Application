package com.example.android.mynotes

import androidx.lifecycle.LiveData

class NoteRepository(private val notesDao: Dao) {

    val allNotes: LiveData<List<Note>> = notesDao.getAllNote()

        suspend fun insert(note: Note){
            notesDao.insert(note)
        }
        suspend fun delete(note: Note){
            notesDao.delete(note)
        }

}