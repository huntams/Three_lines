package com.example.three_lines.domain

import com.example.three_lines.data.Note
import com.example.three_lines.data.repository.NoteRepositoryImpl
import com.example.three_lines.data.repository.NotesRepository

class GetNotesUseCase(
    private val notesRepository: NotesRepository = NoteRepositoryImpl()
) {
    fun execute(): List<Note>{
        return notesRepository.getNotes()
    }
}