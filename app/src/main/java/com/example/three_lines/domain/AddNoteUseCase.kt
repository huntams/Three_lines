package com.example.three_lines.domain

import com.example.three_lines.data.repository.NoteRepositoryImpl
import com.example.three_lines.data.repository.NotesRepository

class AddNoteUseCase(private val notesRepository : NotesRepository = NoteRepositoryImpl()
) {
    suspend fun execute(text: String){
        notesRepository.addNote(text)
    }
}