package com.n1akai.countrieschallenge.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.n1akai.countrieschallenge.api.CountriesApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CountriesRepository @Inject constructor(private val countriesApi: CountriesApi) {

    fun getSearchResults(name: String) =
        Pager(
            config = PagingConfig(
                pageSize = 15,
                maxSize = 100,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { CountriesPagingSource(countriesApi, name) }
    ).liveData

}