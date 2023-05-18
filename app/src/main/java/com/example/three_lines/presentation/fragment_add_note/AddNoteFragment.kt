package com.example.three_lines.presentation.fragment_add_note


import android.graphics.Bitmap
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.view.drawToBitmap
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.three_lines.R
import com.example.three_lines.databinding.FragmentAddNoteBinding
import com.example.three_lines.presentation.list.NotesListViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.io.ByteArrayOutputStream

@AndroidEntryPoint
class AddNoteFragment : Fragment(R.layout.fragment_add_note) {
    private fun vision(close: Int, add: Int) {
        with(binding) {
            buttonClose.visibility = close
            closeAddImageView.visibility = close
            buttonAddImage.visibility = add
        }
    }
    private fun Bitmap.convertToByteArray(): ByteArray = ByteArrayOutputStream().apply {
        compress(Bitmap.CompressFormat.JPEG, 50, this)
    }.toByteArray()

    private var uri: ByteArray = byteArrayOf()
    private val viewModel by viewModels<NotesListViewModel>()
    private val binding by viewBinding(FragmentAddNoteBinding::bind)
    private val pickMedia =
        registerForActivityResult(ActivityResultContracts.PickVisualMedia()) { uriImage ->
            if (uriImage != null) {
                with(binding) {

                    closeAddImageView.setImageURI(uriImage)
                    uri = closeAddImageView.drawToBitmap().convertToByteArray()
                    vision(View.VISIBLE, View.INVISIBLE)
                }
            } else {
                Toast.makeText(context, "Изображение не было выбрано", Toast.LENGTH_SHORT).show()
            }
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            buttonAddImage.setOnClickListener {
                // Launch the photo picker and let the user choose only images.
                pickMedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
                Toast.makeText(context, pickMedia.toString(), Toast.LENGTH_SHORT).show()
            }
            toolbar.setNavigationOnClickListener {
                findNavController().popBackStack()
            }
            buttonClose.setOnClickListener {
                vision(View.INVISIBLE, View.VISIBLE)
                uri = byteArrayOf()
            }
            floatingActionButton.setOnClickListener {
                if (uri.isNotEmpty()) {

                    viewModel.onAddClicked(editTextNote.text.toString(), uri)
                    findNavController().popBackStack()
                } else
                    Toast.makeText(context, "Изображение не было выбрано", Toast.LENGTH_SHORT)
                        .show()
            }
        }
    }
}