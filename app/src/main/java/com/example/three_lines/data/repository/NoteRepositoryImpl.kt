package com.example.three_lines.data.repository

import com.example.three_lines.data.Note
import com.example.three_lines.data.NotesDataSource
import com.example.three_lines.data.mappers.NotesMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class NoteRepositoryImpl(
    private val notesDataSource: NotesDataSource = NotesDataSource,
    private val notesMapper: NotesMapper = NotesMapper(),
) : NotesRepository {
    override fun getNotes(): Flow<List<Note>> {
        return notesDataSource.getNotes().map { list ->
            list.map {
                notesMapper.fromEntityToUIModel(it)
            }
        }
    }

    override suspend fun addNote(text: String) {
        notesDataSource.addNote(text)
    }
}