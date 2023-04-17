package com.example.three_lines.data.mappers

import com.example.three_lines.data.Note
import com.example.three_lines.data.db.model.NoteEntity

class NotesMapper {
    fun fromEntityToUIModel(entity: NoteEntity) : Note {

        return  Note(
            id = entity.id,
            text = entity.text
        )

    }
}