package com.example.three_lines.data



data class Note(
    val id: Long,
    val text: String,
    val uri: ByteArray,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Note

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
