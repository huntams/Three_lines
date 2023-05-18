package com.example.three_lines.presentation.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.three_lines.data.Note
import com.example.three_lines.databinding.ItemNoteBinding

class NoteListAdapter : ListAdapter<Note,NoteListAdapter.NoteViewHolder>(diffUtil)  {
    private var onNoteClick : (Note) -> Unit = {}
    fun setCallBack(callback: (Note)->Unit){
        this.onNoteClick = callback
    }
    private var onNoteLongClick: (Note) -> Unit = {}

    fun setLongCallBack(callback: (Note) -> Unit) {
        this.onNoteLongClick = callback
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
                root.setOnLongClickListener {
                    onNoteLongClick(item)
                    true
                }
            }
        }
    }
}
val diffUtil = object : DiffUtil.ItemCallback<Note>() {

    override fun areContentsTheSame(oldItem: Note, newItem: Note) = oldItem==newItem

    override fun areItemsTheSame(oldItem: Note, newItem: Note)= oldItem.id == newItem.id
}
