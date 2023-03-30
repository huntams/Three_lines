package com.example.three_lines

import java.util.UUID

data class DataModel(
    val title: String,
    val subtitle: String,
    val id : String = UUID.randomUUID().toString(),
)
