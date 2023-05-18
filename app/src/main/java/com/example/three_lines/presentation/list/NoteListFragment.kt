package com.example.three_lines.presentation.list

import android.graphics.Bitmap
import android.os.Bundle
import android.view.View
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.three_lines.R
import com.example.three_lines.databinding.FragmentNoteListBinding
import dagger.hilt.android.AndroidEntryPoint
import java.io.ByteArrayOutputStream
import javax.inject.Inject


@AndroidEntryPoint
class NoteListFragment : Fragment(R.layout.fragment_note_list) {

    private val binding by viewBinding(FragmentNoteListBinding::bind)
    private val viewModel by viewModels<NotesListViewModel>()
    @Inject
    lateinit var listAdapter: NoteListAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        viewModel.getNotes()
        with(binding) {
            val searchView = toolbar.menu.findItem(R.id.appSearchBar).actionView as SearchView
            searchView.queryHint = "Search"

            recyclerview.apply {


                layoutManager = StaggeredGridLayoutManager(2, RecyclerView.VERTICAL)

                adapter = listAdapter.apply {

                    setLongCallBack { note ->

                        Toast.makeText(
                            requireContext(),
                            "Запись : \"" + note.text + "\" удалена",
                            Toast.LENGTH_SHORT
                        ).show()
                        viewModel.filterNote("привет")
                        viewModel.onDeleteClicked(note)
                    }
                }

            }


            floatingActionButton.setOnClickListener {
                findNavController().navigate(
                    NoteListFragmentDirections.actionNoteListFragmentToAddNoteFragment2()
                )
            }
            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(p0: String?): Boolean {
                    viewModel.filterNote(p0.toString())
                    return true
                }

                override fun onQueryTextChange(p0: String?): Boolean {
                    viewModel.filterNote(p0.toString())
                    return true

                }
            })
            viewModel.notesListLiveData.observe(viewLifecycleOwner) {
                listAdapter.submitList(it)
            }
        }
    }

}