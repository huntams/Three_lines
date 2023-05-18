package com.example.three_lines.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.three_lines.data.db.model.NoteEntity


@Database(entities = [NoteEntity::class], version = 1)
abstract class NotesDB : RoomDatabase() {
    abstract fun notesDAO(): NotesDAO
}