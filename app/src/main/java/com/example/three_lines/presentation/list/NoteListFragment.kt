package com.example.three_lines.presentation.list

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.three_lines.R
import com.example.three_lines.databinding.FragmentNoteListBinding

class NoteListFragment : Fragment(R.layout.fragment_note_list) {


    private val binding by viewBinding(FragmentNoteListBinding::bind)
    private val viewModel by viewModels<NotesListViewModel>()
    private val listAdapter = NoteListAdapter()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getNotes()
        with(binding) {
            recyclerview.apply {


                layoutManager = StaggeredGridLayoutManager(2, RecyclerView.VERTICAL)
                adapter = listAdapter.apply {
                    setLongCallBack { note ->
                        Toast.makeText(
                            requireContext(),
                            "Запись : \"" + note.text + "\" удалена",
                            Toast.LENGTH_SHORT
                        ).show()
                        viewModel.onDeleteClicked(note)
                    }
                }
            }
            floatingActionButton.setOnClickListener {
                findNavController().navigate(
                    NoteListFragmentDirections.actionNoteListFragmentToAddNoteFragment()
                )
            }
            viewModel.notesListLiveData.observe(viewLifecycleOwner) {
                listAdapter.submitList(it)
            }
        }
    }
}