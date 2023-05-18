package com.example.three_lines.presentation.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.three_lines.data.Note
import com.example.three_lines.domain.AddNoteUseCase
import com.example.three_lines.domain.DeleteNoteUseCase
import com.example.three_lines.domain.FilterNotesUseCase
import com.example.three_lines.domain.GetNotesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotesListViewModel @Inject constructor(
    private val getNotesUseCase: GetNotesUseCase,
    private val addNoteUseCase: AddNoteUseCase,
    private val deleteNoteUseCase: DeleteNoteUseCase,
    private val filterNotesUseCase: FilterNotesUseCase,
) : ViewModel() {

    private val _notesListLiveData = MutableLiveData<List<Note>>()
    val notesListLiveData: LiveData<List<Note>> = _notesListLiveData
    fun onAddClicked(text: String, uri: ByteArray) {
        viewModelScope.launch {
            addNoteUseCase.execute(text, uri)
            getNotes()
        }
    }

    fun getNotes() {
        viewModelScope.launch {
            getNotesUseCase.execute().collect { list ->
                _notesListLiveData.value = list.map {

                    it.copy(
                        text = it.text,
                        uri = it.uri,
                    )
                }
            }
        }
    }

    fun filterNote(data: String) {
        viewModelScope.launch {
            filterNotesUseCase.execute(data).collect { list ->
                _notesListLiveData.value = list.map {
                    it.copy(
                        text = it.text,
                        uri = it.uri,
                    )
                }

            }

        }
    }

    fun onDeleteClicked(note: Note) {
        viewModelScope.launch {
            deleteNoteUseCase.execute(note)
            getNotes()
        }
    }
}