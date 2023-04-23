package com.example.three_lines.data

object NotesDataSource {
    val notesList = mutableListOf<Note>()
    fun addNote(text : String){
        notesList.add(Note(text = text))
    }
    fun removeNote(text : String){
        notesList.remove(Note(text = text))
    }
}