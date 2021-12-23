package com.hafidmust.mylivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.hafidmust.mylivedata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        subscribe()
    }

    private fun subscribe() {
        val elapsedTimeObserver = Observer<Long?>{along ->
            val newText = this.resources.getString(R.string.seconds, along)
            binding.timerTextview.text = newText
        }
        viewModel.getElapsedTime().observe(this,elapsedTimeObserver)
    }
}