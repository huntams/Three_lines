package com.example.three_lines

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.three_lines.databinding.ActivityMainBinding
import com.example.three_lines.second_activity.SecondActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val listAdapter by lazy {
        DataListAdapter()
    }


        private val dataList = listOf(
            DataModel("rand1","subrand2"),
            DataModel("rand3","subrand4"),
            DataModel("rand5","subrand6"),
            DataModel("rand7","subrand8"),

            )

    /*private val dataList = mutableListOf<DataModel>().apply {
        repeat(10) {
            add(DataModel())
        }

    }

     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        }

}