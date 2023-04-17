package com.example.three_lines.data.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Notes")
data class NoteEntity(

    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val text: String,
)