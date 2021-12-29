package com.hafidmust.moviecatalogue2.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.hafidmust.moviecatalogue2.R

class DetailActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_ID = "extra_id"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

//        viewmodel

        val extras = intent.extras
        if (extras != null){
            val dataId = extras.getInt(EXTRA_ID,0)
            Log.d("DetailActivity", dataId.toString())
        }
    }
}