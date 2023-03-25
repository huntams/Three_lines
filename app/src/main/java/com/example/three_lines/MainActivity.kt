package com.example.three_lines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.three_lines.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            viewContact.apply {
                setImage(R.drawable.ic_launcher_foreground)
                setSubTitle("tewta")
                setTitle("gsadgsdagads")
            }
        }
    }

}