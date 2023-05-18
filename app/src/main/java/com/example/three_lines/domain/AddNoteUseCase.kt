package com.example.three_lines.domain


import com.example.three_lines.data.repository.NotesRepository
import javax.inject.Inject

class AddNoteUseCase @Inject constructor(
    private val notesRepository: NotesRepository,
) {
    suspend fun execute(text: String, uri: ByteArray) {
        notesRepository.addNote(text, uri)
    }
}