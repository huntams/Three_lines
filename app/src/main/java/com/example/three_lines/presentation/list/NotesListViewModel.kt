package com.example.three_lines.presentation.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.three_lines.data.Note
import com.example.three_lines.domain.AddNoteUseCase
import com.example.three_lines.domain.GetNotesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
@HiltViewModel
class NotesListViewModel @Inject constructor(
    private val getNotesUseCase: GetNotesUseCase,
    private val addNoteUseCase: AddNoteUseCase,
): ViewModel() {

    private val _notesListLiveData = MutableLiveData<List<Note>>()
    val notesListLiveData : LiveData<List<Note>> = _notesListLiveData
    fun onAddClicked(text: String){
        viewModelScope.launch {
            addNoteUseCase.execute(text)
            getNotes()
        }
    }
    fun getNotes(){
      viewModelScope.launch {
          getNotesUseCase.execute().collect{list->
              _notesListLiveData.value = list.map{

                  it.copy(
                      text = it.text
                  )
              }
          }
      }
    }
}