package com.example.three_lines.domain

import com.example.three_lines.data.Note
import com.example.three_lines.data.repository.NoteRepositoryImpl
import com.example.three_lines.data.repository.NotesRepository
import kotlinx.coroutines.flow.Flow

class GetNotesUseCase(
    private val notesRepository: NotesRepository = NoteRepositoryImpl()
) {
    fun execute(): Flow<List<Note>> {
        return notesRepository.getNotes()
    }
}