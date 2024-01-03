package com.n1akai.countrieschallenge.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.n1akai.countrieschallenge.R
import com.n1akai.countrieschallenge.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MainViewModel>()
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val adapter = MyAdapter()
        binding.recyclerView.adapter = adapter
        viewModel.countries.observe(this) {
            adapter.submitData(lifecycle, it)
        }
    }
}