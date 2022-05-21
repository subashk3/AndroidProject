package com.example.viewmodel.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random
import kotlin.random.nextInt

class MyViewModel : ViewModel() {
    var counter = 0
    var randomNumber: String? = null
    val currentCounter: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }


    fun getNumber(): String {
        if (randomNumber == null) {
            generateNumber()
        }
        return randomNumber.toString()
    }

    fun generateNumber() {
        randomNumber = Random.nextInt(1..10).toString()
    }
}