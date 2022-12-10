package com.example.firstapp

import retrofit2.Response
import retrofit2.http.GET

@JvmSuppressWildcards
interface AppService {
    @GET("https://restcountries.com/v2/all")
    suspend fun getAllCountries(): Response<List<CountryDTO>>?
}