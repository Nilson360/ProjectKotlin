package com.example.firstapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    var count: MutableLiveData<Int> = MutableLiveData(0)
    fun plus() {
        count.value = count.value?.plus(1)
    }

    fun moins() {
        count.value = count.value?.minus(1)
    }
}