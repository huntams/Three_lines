package com.example.three_lines.data.db

import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.three_lines.NotesApplication

object NotesDBObject {
    const val DB_NAME = "NotesDatabase"

    var dao: NotesDAO? = null
        get() {
            return if (field == null) {
                field = db?.notesDAO()
                field
            } else {
                field
            }
        }
    var db: NotesDB? = null
        private set
        get() {
            return if (field == null) {
                field = getNotesDAO()
                field
            } else {
                field
            }
        }


    private fun getNotesDAO(): NotesDB? {
        return NotesApplication.getApplicationContext()?.let { context ->
            Room.databaseBuilder(
                context,
                NotesDB::class.java,
                DB_NAME
            ).build()
        }
    }
}