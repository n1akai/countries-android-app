package com.n1akai.countrieschallenge.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.n1akai.countrieschallenge.data.CountriesRepository
import javax.inject.Inject

class MainViewModel @Inject constructor(private val repository: CountriesRepository) : ViewModel() {


    companion object {
        private const val DEFAULT_QUERY = "Morocco";
    }

    private val currentQuery = MutableLiveData(DEFAULT_QUERY)
    val countries = currentQuery.switchMap {
        repository.getSearchResults(it)
    }

    fun searchCountry(name: String) {
        currentQuery.value = name
    }

}