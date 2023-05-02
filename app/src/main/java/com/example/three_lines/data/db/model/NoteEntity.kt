package com.example.three_lines.data.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Notes")
data class NoteEntity(

    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val text: String,
    val uri: ByteArray,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as NoteEntity

        if (id != other.id) return false
        if (text != other.text) return false
        if (!uri.contentEquals(other.uri)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + text.hashCode()
        result = 31 * result + uri.contentHashCode()
        return result
    }
}