package com.example.three_lines.presentation.list

import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.ScrollCaptureCallback
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.three_lines.DataModel
import com.example.three_lines.data.Note
import com.example.three_lines.databinding.FragmentNoteListBinding
import com.example.three_lines.databinding.ItemNoteBinding
import com.example.three_lines.databinding.ViewContactBinding
import javax.inject.Inject
import kotlin.coroutines.coroutineContext

class NoteListAdapter @Inject constructor() :
    ListAdapter<Note, NoteListAdapter.NoteViewHolder>(diffUtil) {
    private var onNoteClick: (Note) -> Unit = {}
    private var onNoteLongClick: (Note) -> Unit = {}
    fun setCallBack(callback: (Note) -> Unit) {
        this.onNoteClick = callback
    }

    fun setLongCallBack(callback: (Note) -> Unit) {
        this.onNoteLongClick = callback
    }

    fun swipeCallBack(callback: (Note) -> Unit) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val binding = ItemNoteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NoteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class NoteViewHolder(
        private var binding: ItemNoteBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Note) {
            with(binding) {
                root.setOnClickListener { onNoteClick(item) }
                root.setOnLongClickListener {
                    onNoteLongClick(item)
                    true
                }
                textViewText.text = item.text

                /*
                Glide.with(itemView)
                    .load(item.uri)
                    .override(100)
                    .into(closeImageView)

                 */
                closeImageView.setImageBitmap(
                    BitmapFactory.decodeByteArray(
                        item.uri,
                        0,
                        item.uri.size
                    )
                )
            }
        }
    }
}

val diffUtil = object : DiffUtil.ItemCallback<Note>() {

    override fun areContentsTheSame(oldItem: Note, newItem: Note) = oldItem == newItem

    override fun areItemsTheSame(oldItem: Note, newItem: Note) = oldItem.id == newItem.id
}
