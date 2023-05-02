package com.example.three_lines.data.repository

import com.example.three_lines.data.Note
import com.example.three_lines.data.db.NotesDAO
import com.example.three_lines.data.db.model.NoteEntity
import com.example.three_lines.data.mappers.NotesMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(
    private val notesMapper: NotesMapper = NotesMapper(),
    private val notesDAO: NotesDAO,
) : NotesRepository {
    override fun getNotes(): Flow<List<Note>> {
        return notesDAO.getNotes().map { list ->
            list.map {
                notesMapper.fromEntityToUIModel(it)
            }
        }
    }

    override fun filterNotes(data: String): Flow<List<Note>> {
        return notesDAO.filterNotes(data).map { list->
            list.map {
                notesMapper.fromEntityToUIModel(it)
            }
        }
    }

    override suspend fun addNote(text: String, uri: ByteArray) {
        notesDAO.addNote(NoteEntity(text = text, uri = uri))
    }

    override suspend fun deleteNote(note: Note) {
        notesDAO.deleteNote(notesMapper.fromUIModelToEntity(note))
    }
}