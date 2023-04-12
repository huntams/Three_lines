package com.example.three_lines.data.repository

import com.example.three_lines.data.Note
import com.example.three_lines.data.NotesDataSource
import kotlinx.coroutines.flow.Flow

class NoteRepositoryImpl(
    private val notesDataSource : NotesDataSource = NotesDataSource
) : NotesRepository {
    override fun getNotes():Flow<List<Note>> {
            return notesDataSource.getNotes()
    }

    override suspend fun addNote(text: String) {
        notesDataSource.addNote(text)
    }
}