package com.example.three_lines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.three_lines.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val listAdapter by lazy {
        DataListAdapter()
    }

    /*
        private val dataList = listOf(
            DataModel("rand1","subrand2"),
            DataModel("rand3","subrand4"),
            DataModel("rand5","subrand6"),
            DataModel("rand7","subrand8"),

            )
     */
    private val dataList = mutableListOf<DataModel>().apply {
        repeat(10) {
            add(DataModel())
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var size: Int = 0
        binding.recyclerView.adapter = listAdapter
        binding.ButtonAdd.setOnClickListener {
            dataList.add(DataModel())
            listAdapter.submitList(dataList.toList())
            //size++
            //listAdapter.submitList(dataList.take(size))

        }
        binding.ButtonRemove.setOnClickListener {
            //if(size!=0) {
            //   size--
            //  listAdapter.submitList(dataList.take(size))
            //}
            dataList.removeLastOrNull()
            listAdapter.submitList(dataList.toList())
        }
        listAdapter.setCallback { model ->
            Toast.makeText(this, model.title, Toast.LENGTH_LONG).show()
        }
        binding.recyclerView.adapter = listAdapter
    }

}