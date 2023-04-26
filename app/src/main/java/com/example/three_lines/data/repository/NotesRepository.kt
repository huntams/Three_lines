package com.example.three_lines.data.repository

import com.example.three_lines.data.Note
import kotlinx.coroutines.flow.Flow

interface NotesRepository {
    fun getNotes(): Flow<List<Note>>
    suspend fun addNote(text: String)

    suspend fun deleteNote(note: Note)

}