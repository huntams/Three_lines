package com.example.three_lines.data.mappers

import com.example.three_lines.data.Note
import com.example.three_lines.data.db.model.NoteEntity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NotesMapper @Inject constructor() {
    fun fromEntityToUIModel(entity: NoteEntity) : Note {

        return  Note(
            id = entity.id,
            text = entity.text,
            uri = entity.uri,
        )

    }
    fun fromUIModelToEntity(note: Note) : NoteEntity {

        return  NoteEntity(
            id = note.id,
            text = note.text,
            uri = note.uri,
        )

    }
}