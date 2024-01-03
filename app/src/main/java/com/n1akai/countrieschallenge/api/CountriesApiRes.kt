package com.n1akai.countrieschallenge.api

import com.n1akai.countrieschallenge.data.Country

data class CountriesApiRes(
    val results: List<Country>
) {
}