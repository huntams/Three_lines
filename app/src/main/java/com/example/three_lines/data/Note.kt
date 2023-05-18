package com.example.three_lines.data

import java.util.*

data class Note(
    val id : String = UUID.randomUUID().toString(),
    val text : String,
)
