package com.example.myapplication
import retrofit2.Response
import retrofit2.http.GET

@JvmSuppressWildcards
interface AppService {
    @GET("https://restcountries.com/v3.1:all")
    fun getAllCountries(): Response<List<CountryDTO>>
}