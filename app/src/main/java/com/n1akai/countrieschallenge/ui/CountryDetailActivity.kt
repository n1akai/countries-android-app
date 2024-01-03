package com.n1akai.countrieschallenge.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.n1akai.countrieschallenge.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CountryDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country_detail)
    }
}