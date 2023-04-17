package com.example.three_lines.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.three_lines.NotesApplication
import com.example.three_lines.data.db.NotesDB
import com.example.three_lines.data.db.NotesDBObject
import com.example.three_lines.data.db.model.NoteEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.map

object NotesDataSource {

    suspend fun addNote(text: String) {
        NotesDBObject.dao?.addNote(NoteEntity(text = text))
    }

    fun getNotes(): Flow<List<NoteEntity>> {
        return NotesDBObject.dao?.getNotes() ?: emptyFlow()
    }


}

