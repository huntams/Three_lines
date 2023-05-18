package com.example.three_lines.di

import com.example.three_lines.data.repository.NoteRepositoryImpl
import com.example.three_lines.data.repository.NotesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindNotesRepository(impl: NoteRepositoryImpl): NotesRepository
}