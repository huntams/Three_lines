package com.example.three_lines

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.three_lines.databinding.ActivityMainBinding
import com.example.three_lines.databinding.ViewContactBinding

class DataListAdapter : ListAdapter<DataModel, DataListAdapter.DataViewHolder>(diffUtilCallback) {

    private var onClick : ( DataModel,String)-> Unit = {}
    fun setCallback(callback :(DataModel) -> Unit){
        this.onClick = callback
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val binding = ViewContactBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DataViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class DataViewHolder(
        private val binding: ViewContactBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: DataModel) {
            with(binding) {
                head.text = item.title
                subhead.text = item.subtitle
                root.setOnClickListener {
                    onClick.invoke(item)
                }
            }

        }
    }
}

val diffUtilCallback = object : DiffUtil.ItemCallback<DataModel>() {

    override fun areContentsTheSame(oldItem: DataModel, newItem: DataModel): Boolean {
        return oldItem == newItem
    }

    override fun areItemsTheSame(oldItem: DataModel, newItem: DataModel): Boolean {
        return oldItem.id == newItem.id
    }
}
