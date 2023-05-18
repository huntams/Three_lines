package com.example.three_lines.domain

import com.example.three_lines.data.Note
import com.example.three_lines.data.repository.NotesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FilterNotesUseCase @Inject constructor(
    private val notesRepository: NotesRepository,
) {
    fun execute(data: String): Flow<List<Note>> {
        return notesRepository.filterNotes(data = data)
    }
}