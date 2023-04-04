package com.example.three_lines.fragment2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.three_lines.R
import com.example.three_lines.databinding.SecondFragmentBinding
import com.example.three_lines.fragment1.FirstFragment

class SecondFragment : Fragment(R.layout.second_fragment) {
    private val binding by viewBinding(SecondFragmentBinding:: bind)
    private val args by navArgs<SecondFragmentArgs>()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.textViewText.text = args.text
    }
}