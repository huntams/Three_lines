package com.example.three_lines.presentation.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.three_lines.data.Note
import com.example.three_lines.domain.AddNoteUseCase
import com.example.three_lines.domain.DeleteNoteUseCase
import com.example.three_lines.domain.GetNotesUseCase
import kotlinx.coroutines.launch

class NotesListViewModel(
    private val getNotesUseCase: GetNotesUseCase = GetNotesUseCase(),
    private val addNoteUseCase: AddNoteUseCase = AddNoteUseCase(),
    private val deleteNoteUseCase: DeleteNoteUseCase = DeleteNoteUseCase(),
): ViewModel() {

    private val _notesListLiveData = MutableLiveData<List<Note>>()
    val notesListLiveData : LiveData<List<Note>> = _notesListLiveData
    fun onAddClicked(text: String){
        addNoteUseCase.execute(text)
        getNotes()
    }
    fun getNotes(){
      _notesListLiveData.value =  getNotesUseCase.execute().toList()
    }

    fun onDeleteClicked(note: Note) {
            deleteNoteUseCase.execute(note)
            getNotes()
    }
}