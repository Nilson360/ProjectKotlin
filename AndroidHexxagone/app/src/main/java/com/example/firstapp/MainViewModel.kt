package com.example.firstapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainViewModel : ViewModel() {
    private val retrofit: Retrofit = Retrofit.Builder().baseUrl("https://restcountries.com/v2/")
        .addConverterFactory(GsonConverterFactory.create()).build()
    var count: MutableLiveData<Int> = MutableLiveData(0)
    var countries: MutableLiveData<List<CountryDTO>> = MutableLiveData(emptyList())
    val appService: AppService = retrofit.create(AppService::class.java)
    fun plus() {
        count.value = count.value?.plus(1)
    }

    fun moins() {
        count.value = count.value?.minus(1)
    }

    fun getAllCountries() {
        viewModelScope.launch {
            val response = appService.getAllCountries()
            if (response == null || !response.isSuccessful) {
                return@launch
            }
            val body = response.body()
            println("Here is my body $body")
            countries.value = body
        }
    }
}