package com.example.viewmodel.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random
import kotlin.random.nextInt

class MyViewModel : ViewModel() {
    var counter = 0
    var randomNumberValue = 0

    val randomNumber: MutableLiveData<String> by lazy { MutableLiveData<String>() }

    val currentCounter: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }


    fun getNumber(): MutableLiveData<String>? {
        if (randomNumber == null) {
            generateNumber()
        }
        return randomNumber
    }

    fun generateNumber() {
        randomNumber?.value = Random.nextInt(1..10).toString()
    }
}