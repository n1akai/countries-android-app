package com.n1akai.countrieschallenge.data

import android.net.http.HttpException
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.n1akai.countrieschallenge.api.CountriesApi
import java.io.IOException

private const val COUNTRIES_STARTING_PAGE_INDEX = 1;

class CountriesPagingSource(private val countriesApi: CountriesApi, private val name: String) : PagingSource<Int, Country>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Country> {
        val position = params.key ?: COUNTRIES_STARTING_PAGE_INDEX

        return try {
            val res = countriesApi.searchCountry(name)
            val countries = res.results
            LoadResult.Page(
                data = countries,
                prevKey = if (position == COUNTRIES_STARTING_PAGE_INDEX) null else position - 1,
                nextKey = if (countries.isEmpty()) null else position + 1
            )
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Country>): Int? {
        TODO("Not yet implemented")
    }
}