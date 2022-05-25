package com.example.firstapp

import androidx.core.view.ContentInfoCompat

data class CountryDTO(
    val Country: CountriesDto,
)

data class CountriesDto(
    val name: String,
    val capital: String,
    val population: Int,
    val flags: FlagsCountries,
    val region: String
)

data class FlagsCountries(
    val png: String,
    val svg: String,
)