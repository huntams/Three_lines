package com.example.three_lines.data.repository

import com.example.three_lines.data.Note
import com.example.three_lines.data.NotesDataSource

class NoteRepositoryImpl(
    private val notesDataSource : NotesDataSource = NotesDataSource
) : NotesRepository {
    override fun getNotes(): List<Note> {
            return notesDataSource.notesList
    }

    override fun addNote(text: String) {
        notesDataSource.addNote(text)
    }

    override fun removeNotes() {
        TODO("Not yet implemented")
    }
}