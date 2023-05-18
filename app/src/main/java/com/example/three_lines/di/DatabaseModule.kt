package com.example.three_lines.di

import android.content.Context
import androidx.room.Room
import com.example.three_lines.data.db.NotesDAO
import com.example.three_lines.data.db.NotesDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    private const val DB_NAME = "NotesDatabase"

    @Provides
    @Singleton
    fun provideNotesDatabase(
        @ApplicationContext context: Context,
    ): NotesDB {
        return Room.databaseBuilder(
            context,
            NotesDB::class.java,
            DB_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideNotesDAO(db: NotesDB): NotesDAO {
        return db.notesDAO()
    }
}