package com.example.three_lines.presentation.list

import android.view.LayoutInflater
import android.view.ScrollCaptureCallback
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.three_lines.DataModel
import com.example.three_lines.data.Note
import com.example.three_lines.databinding.FragmentNoteListBinding
import com.example.three_lines.databinding.ItemNoteBinding
import com.example.three_lines.databinding.ViewContactBinding

class NoteListAdapter : ListAdapter<Note,NoteListAdapter.NoteViewHolder>(diffUtil)  {
    private var onNoteClick : (Note) -> Unit = {}
    fun setCallBack(callback: (Note)->Unit){
        this.onNoteClick = callback
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
            with(binding){
                root.setOnClickListener { onNoteClick(item) }
                textViewText.text = item.text
            }
        }
    }
}
val diffUtil = object : DiffUtil.ItemCallback<Note>() {

    override fun areContentsTheSame(oldItem: Note, newItem: Note) = oldItem==newItem

    override fun areItemsTheSame(oldItem: Note, newItem: Note)= oldItem.id == newItem.id
}
