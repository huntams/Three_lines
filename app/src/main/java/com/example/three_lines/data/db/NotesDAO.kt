package com.example.three_lines.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.three_lines.data.db.model.NoteEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface NotesDAO {
    @Insert
    suspend fun addNote(note: NoteEntity): Long

    @Query("SELECT * FROM Notes")
    fun getNotes(): Flow<List<NoteEntity>>

    @Delete
    suspend fun deleteNote(note: NoteEntity)
}