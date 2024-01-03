package com.n1akai.countrieschallenge.api

import retrofit2.http.GET
import retrofit2.http.Path

interface CountriesApi {

    companion object {
        const val BASE_URL = "https://restcountries.com/v3.1/"
    }

    @GET("name/{name}")
    suspend fun searchCountry(
        @Path("name") name: String
    ) : CountriesApiRes;

}