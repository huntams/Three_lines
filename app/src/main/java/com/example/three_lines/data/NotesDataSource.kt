package com.example.three_lines.data

object NotesDataSource {
    val notesList = mutableListOf<Note>()
    fun addNote(text : String){
        notesList.add(Note(text = text))
    }
    fun deleteNote(note: Note){
        notesList.remove(note)
    }
}