package com.example.three_lines.data.repository

import com.example.three_lines.data.Note

interface NotesRepository {
    fun getNotes() : List<Note>
    fun addNote(text: String)
}